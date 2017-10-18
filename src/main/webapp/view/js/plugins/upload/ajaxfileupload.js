
jQuery.extend({
	

    createUploadIframe: function(id, uri)
	{
			//create frame
            var frameId = 'jUploadFrame' + id;
            var iframeHtml = '<iframe id="' + frameId + '" name="' + frameId + '" style="position:absolute; top:-9999px; left:-9999px"';
			if(window.ActiveXObject)
			{
                if(typeof uri== 'boolean'){
					iframeHtml += ' src="' + 'javascript:false' + '"';

                }
                else if(typeof uri== 'string'){
					iframeHtml += ' src="' + uri + '"';

                }	
			}
			iframeHtml += ' />';
			jQuery(iframeHtml).appendTo(document.body);

            return jQuery('#' + frameId).get(0);			
    },
    createUploadForm: function(id, fileElementId, data)
	{
		//create form	
		var formId = 'jUploadForm' + id;
		var fileId = 'jUploadFile' + id;
		var form = jQuery('<form  action="" method="POST" name="' + formId + '" id="' + formId + '" enctype="multipart/form-data"></form>');	
		if(data)
		{
			for(var i in data)
			{
				jQuery('<input type="hidden" name="' + i + '" value="' + data[i] + '" />').appendTo(form);
			}			
		}		
		var oldElement = jQuery('#' + fileElementId);
		var newElement = jQuery(oldElement).clone();
		jQuery(oldElement).attr('id', fileId);
		jQuery(oldElement).before(newElement);
		jQuery(oldElement).appendTo(form);


		
		//set attributes
		jQuery(form).css('position', 'absolute');
		jQuery(form).css('top', '-1200px');
		jQuery(form).css('left', '-1200px');
		jQuery(form).appendTo('body');		
		return form;
    },

    ajaxFileUpload: function(s) {
        // TODO introduce global settings, allowing the client to modify them for all requests, not only timeout		
        s = jQuery.extend({}, jQuery.ajaxSettings, s);
        var id = new Date().getTime();        
		var form = jQuery.createUploadForm(id, s.fileElementId, (typeof(s.data)=='undefined'?false:s.data));
		var io = jQuery.createUploadIframe(id, s.secureuri);
		var frameId = 'jUploadFrame' + id;
		var formId = 'jUploadForm' + id;		
        // Watch for a new set of requests
        if ( s.global && ! jQuery.active++ )
		{
			jQuery.event.trigger( "ajaxStart" );
		}            
        var requestDone = false;
        // Create the request object
        var xml = {};   
        if ( s.global )
            jQuery.event.trigger("ajaxSend", [xml, s]);
        // Wait for a response to come back
        var uploadCallback = function(isTimeout)
		{			
			var io = document.getElementById(frameId);
            try 
			{				
				if(io.contentWindow)
				{
					 xml.responseText = io.contentWindow.document.body?io.contentWindow.document.body.innerHTML:null;
                	 xml.responseXML = io.contentWindow.document.XMLDocument?io.contentWindow.document.XMLDocument:io.contentWindow.document;
					 
				}else if(io.contentDocument)
				{
					xml.responseText = io.contentDocument.document.body?io.contentDocument.document.body.innerHTML:null;
                	xml.responseXML = io.contentDocument.document.XMLDocument?io.contentDocument.document.XMLDocument:io.contentDocument.document;
				}						
            }catch(e)
			{
				jQuery.handleError(s, xml, null, e);
			}
            if ( xml || isTimeout == "timeout") 
			{				
                requestDone = true;
                var status;
                try {
                    status = isTimeout != "timeout" ? "success" : "error";
                    // Make sure that the request was successful or notmodified
                    if ( status != "error" )
					{
                        // process the data (runs the xml through httpData regardless of callback)
                        var data = jQuery.uploadHttpData( xml, s.dataType );    
                        // If a local callback was specified, fire it and pass it the data
                        if ( s.success )
                            s.success( data, status );
    
                        // Fire the global callback
                        if( s.global )
                            jQuery.event.trigger( "ajaxSuccess", [xml, s] );
                    } else
                        jQuery.handleError(s, xml, status);
                } catch(e) 
				{
                    status = "error";
                    jQuery.handleError(s, xml, status, e);
                }

                // The request was completed
                if( s.global )
                    jQuery.event.trigger( "ajaxComplete", [xml, s] );

                // Handle the global AJAX counter
                if ( s.global && ! --jQuery.active )
                    jQuery.event.trigger( "ajaxStop" );

                // Process result
                if ( s.complete )
                    s.complete(xml, status);

                jQuery(io).unbind();

                setTimeout(function()
									{	try 
										{
											jQuery(io).remove();
											jQuery(form).remove();	
											
										} catch(e) 
										{
											jQuery.handleError(s, xml, null, e);
										}									

									}, 100);

                xml = null;

            }
        };
        // Timeout checker
        if ( s.timeout > 0 ) 
		{
            setTimeout(function(){
                // Check to see if the request is still happening
                if( !requestDone ) uploadCallback( "timeout" );
            }, s.timeout);
        }
        try 
		{

			var form = jQuery('#' + formId);
			jQuery(form).attr('action', s.url);
			jQuery(form).attr('method', 'POST');
			jQuery(form).attr('target', frameId);
            if(form.encoding)
			{
				jQuery(form).attr('encoding', 'multipart/form-data');      			
            }
            else
			{	
				jQuery(form).attr('enctype', 'multipart/form-data');			
            }			
            jQuery(form).submit();

        } catch(e) 
		{			
            jQuery.handleError(s, xml, null, e);
        }
		
		jQuery('#' + frameId).load(uploadCallback	);
        return {abort: function () {}};	

    },

    uploadHttpData: function( r, type ) {
        var data = !type;
        data = type == "xml" || data ? r.responseXML : r.responseText;
        // If the type is "script", eval it in global context
        if ( type == "script" )
            jQuery.globalEval( data );
        // Get the JavaScript object, if JSON is used.
        if ( type == "json" )
            eval( "data = " + data );
        // evaluate scripts within html
        if ( type == "html" )
            jQuery("<div>").html(data).evalScripts();

        return data;
    }
});




//------------------------------------------调用的文件上传组件-----------------------------------------------------
	/**
	 * value_fileElementId  type=file的id
	 * value_ctx	项目ctx
	 * uploadfile_component   上传组件div class name
	 */
	function ajaxFileUpload(value_fileElementId,value_ctx,uploadfile_component) {
		var fileUrl = $("#"+value_fileElementId).val();
		if (fileUrl == "") {
			return false;
		}
		uploadfile_component = "."+uploadfile_component;
		$(uploadfile_component+" .tip").progressbar({value : 0});
		$.ajaxFileUpload({
					url : value_ctx+"/uploadfile/UploadServlet.do",
					secureuri : false,
					fileElementId : value_fileElementId,
					dataType : 'json',
					data : {
						"item" : "ajax"
					},
					success : function(data, status) {
						if (typeof (data.error) != 'undefined') {
							if (data.error != '') {
								$(uploadfile_component+" .ajaxuploadfile_two .progressBarText").html(data.error);
							} else {
								$(uploadfile_component+" .ajaxuploadfile_one").hide();
								$(uploadfile_component+" .ajaxuploadfile_two").hide();
								$(uploadfile_component+" .ajaxuploadfile_three").show();
								$(uploadfile_component+" .ajaxuploadfile_two .progress_content").html("100");
								$(uploadfile_component+" .ajaxuploadfile_three .progressBarMsg").html(data.msg);
								handleProcessBar($(uploadfile_component+" .tip"), {"value" : 100}, "normal");
								$(uploadfile_component+" .ajaxuploadfile_one .fileAccessPath").val(data.filepath);
							}
						}
					},
					error : function(data, status, e) {
						alert(e);
					}
				});
			$(uploadfile_component).append('<div class="ajaxuploadfile_two" style="display:none;">'+
								       	   	'<div class="span8">'+
												'<div id="progressbar_default"'+
													'class="tip ui-progressbar ui-widget ui-widget-content ui-corner-all"'+
													'title="上传进度" data-original-title="" role="progressbar"'+
													'aria-valuemin="0" aria-valuemax="100" aria-valuenow=""></div>'+
											'</div>'+
											'<div class="span2"><span class="progressBarText"></span></div>'+
											'<div class="progress_content" style="display: none;"></div>'+
								        '</div>'+
								        '<div class="ajaxuploadfile_three" style="display:none;">'+
								        	'<span class="progressBarMsg"></span>'+
								        '</div>');
			$(uploadfile_component+" .ajaxuploadfile_one").hide();
			$(uploadfile_component+" .ajaxuploadfile_two").show();
			setTimeout("doProgress('"+value_ctx+"','"+uploadfile_component+"')", 1000);
			return false;
	
	}
	
	function doProgress(value_ctx,uploadfile_component) {
		$.ajax({
			cache : false,
	        type: "post",
	        url: value_ctx+"/uploadfile/ProgressServlet.do",
	        data: {
				"item" : "ajax"
			},
	        success: function (data) {   
				doProgressLoop(data,value_ctx,uploadfile_component);
	        },
	        error: function (err) {
	        	$(uploadfile_component+" .ajaxuploadfile_one").hide();
				$(uploadfile_component+" .ajaxuploadfile_two").hide();
				$(uploadfile_component+" .ajaxuploadfile_three").show();
				$(uploadfile_component+" .ajaxuploadfile_three .progressBarMsg").html("进度显示错误");
	        }
	    });
	}
	
	function doProgressLoop(x,value_ctx,uploadfile_component) { 
		var prog=0;
	   	var p = $(uploadfile_component+" .ajaxuploadfile_two .progress_content").html();
		if(x=='Progress listener is null'||x=='Sorry, session is null') {
			return;
		}
	   	var y = parseInt(x);
	   	if (!isNaN(y)) {
	   		prog = y;
	   	}
		if(p=="100") {
			handleProcessBar($(uploadfile_component+" .tip"), { "value" : 100}, "normal");
			$(uploadfile_component+" .ajaxuploadfile_two .progress_content").html("100");
			return;
		}
	
	   	if(prog < 100) {
	   		handleProcessBar($(uploadfile_component+" .tip"), { "value" : prog}, "normal");
	   		setTimeout("doProgress('"+value_ctx+"','"+uploadfile_component+"')", 1000);
	   		$(uploadfile_component+" .ajaxuploadfile_two .progressBarText").html(prog + "%");
	   	}
	}