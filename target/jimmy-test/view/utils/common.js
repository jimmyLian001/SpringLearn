/* global myDateUtil */

/**
 * a + b
 * @param a 
 * @param b
 * @returns a+ b
 */
function numberAdd(a, b) {
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), (numberMul(a, e) + numberMul(b, e)) / e;
}

/**
 * a - b
 * @param a
 * @param b
 * @returns
 */
function numberSub(a, b) {
    var c, d, e;
    try {
        c = a.toString().split(".")[1].length;
    } catch (f) {
        c = 0;
    }
    try {
        d = b.toString().split(".")[1].length;
    } catch (f) {
        d = 0;
    }
    return e = Math.pow(10, Math.max(c, d)), (numberMul(a, e) - numberMul(b, e)) / e;
}

/**
 * a * b
 * @param a
 * @param b
 * @returns {Number} a * b
 */
function numberMul(a, b) {
    var c = 0,
        d = a.toString(),
        e = b.toString();
    try {
        c += d.split(".")[1].length;
    } catch (f) {
    }
    try {
        c += e.split(".")[1].length;
    } catch (f) {
    }
    return Number(d.replace(".", "")) * Number(e.replace(".", "")) / Math.pow(10, c);
}

/**
 * a/b
 * @param a
 * @param b
 * @returns a/b
 */
function numberDiv(a, b) {
    var c, d, e = 0, f = 0;
    try {
        e = a.toString().split(".")[1].length;
    } catch (g) {
    }
    try {
        f = b.toString().split(".")[1].length;
    } catch (g) {
    }
    return c = Number(a.toString().replace(".", "")), d = Number(b.toString().replace(".", "")), numberMul(c / d, Math.pow(10, f - e));
}

/**
 * 创建隐藏的form表单并提交到后台
 * 用于导出数据到excel
 * @param {type} path
 * @param {type} params
 * @param {type} method
 * @returns {undefined}
 */
function createFormAndSubmitUrl(path, params, method) {
    method = method || "post";
    var form = document.createElement("form");
    form.setAttribute("method", method);
    form.setAttribute("action", path);
    for (var i = 0; i < params.length; i++) {
        var hiddenField = document.createElement("input");
        if (params[i].value != null && params[i].value != 'undefined' && params[i].value.length > 0) {
            hiddenField.setAttribute("type", "hidden");
            hiddenField.setAttribute("name", params[i].name);
            hiddenField.setAttribute("value", params[i].value);
            form.appendChild(hiddenField);
        }
    }
    document.body.appendChild(form);
    form.submit();
}

/**
 * options.page
 * @param {type} options grid.options返回数组,故可以使用该写法
 * @param {type} formId 查询表单的id 
 * @returns {Array}
 */
function appendQueryInfoForExport(options, formId) {
    var exportCurPageSize = options.pageSize;//若需做导出当前页的功能，可以此做判断
    var exportAllPageSize = '1048570';//POI单sheet页最大导出行数,这里只能为字符串格式，否则后台无法识别
    var params = [
        {
            name: 'page',
            value: '1'
        },
        {
            name: 'pagesize',
            value: exportAllPageSize
        },
        {
            name: 'sortname',
            value: options.sortName
        },
        {
            name: 'sortorder',
            value: options.sortOrder
        }
    ];
    var queryInfo = $("#" + formId).serializeArray();
    $.merge(params, queryInfo);
    return params;
}

/**
 * 打开导入窗口
 * @param {type} title 导入窗口的title
 * @param {type} tempFileName 导入模板名称,存储在excelTemplate路径下
 * @returns {undefined}
 */
function showImportModalDialog(title, tempFileName) {
    $.ligerDialog.open({
        target: $("#LaunchImport_table_Div"),
        id : "importDialog",
        height: 150,
        width: 500,
        title: title,
        content:'<form id="importFileForm" enctype="multipart/form-data" target="frmHide" class="liger-form">' + 
                '<div class="uploader white">'+
                '<input type="text" id="filename" class="filename" readonly/>'+
                '<input type="button" name="file" class="button" value="上传..."/>'+
                '<input type="file" name="importFile" onchange="'+'$(this).prev().prev().val($(this).val());'+
                '" id="file_import"/></div><div class="uploader white">'+
                '<a href="'+ctx+'/resources/excelTemplate/'+tempFileName+'.xlsx" id="tempExcelDownload" style="text-decoration:none;">下载模板</a></div>',
        showMax: false,
        showToggle: true,
        showMin: false,
        isResize: true,
        buttons: [
            {text: '上传', onclick: function (item, dialog) {
                    if (beforeImport()) {
                        submitFileForm();
                    };
                }},
            {text: '取消', onclick: function (item, dialog) {
                    dialog.close();
                }}
        ]
    });
}

/**
 * 导入前验证文件有效性
 * @param importBtnId
 * @returns 提示文件格式错误或验证通过
 */
function beforeImport(importBtnId) {
    var f_abso = $('#file_import').val();
    if (f_abso == "" || f_abso == null) {
        $.ligerDialog.error("请选择文件！");
        $("#" + importBtnId).attr("disabled", false);
        return false;
    }
    var f_rela;
    if (f_abso.lastIndexOf('\\') != -1) {
        f_rela = f_abso.substring(f_abso.lastIndexOf('\\') + 1);
    } else {
        f_rela = f_abso;
    }
    if (f_rela.lastIndexOf('.xlsx') == -1) {
        $.ligerDialog.error("请选择后缀为 .xlsx 的Excel文件！");
        return false;
    }
    return true;
}
;

function currencyFormatter(num, precision) {
    var cents, sign;
    if (!num)
        num = 0;
    num = num.toString().replace(/\$|\,/g, '').replace(/[a-zA-Z]+/g, '');
    if (num.indexOf('.') > -1)
        num = num.replace(/[0]+$/g, '');
    if (isNaN(num))
        num = 0;
    sign = (num == (num = Math.abs(num)));

    if (precision == null) {
        num = num.toString();
        cents = num.indexOf('.') != -1 ? num.substr(num.indexOf('.') + 1) : '';
        if (cents) {
            num = Math.floor(num * 1);
            num = num.toString();
        }
    } else {
        precision = parseInt(precision);
        var r = Math.pow(10, precision);
        num = Math.floor(num * r + 0.50000000001);
        cents = num % 100;
        num = Math.floor(num / r).toString();
        while (cents.toString().length < precision) {
            cents = "0" + cents;
        }
    }
    for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
        num = num.substring(0, num.length - (4 * i + 3)) + ',' +
                num.substring(num.length - (4 * i + 3));
    var numStr = "" + (((sign) ? '' : '-') + '' + num);
    if (cents)
        numStr += ('.' + cents);
    return numStr;
}

var initCodeDicts = function initCodeDict(cateCode) {
//    var result = "[{id:'*',text:'请选择'},";
    var result = "[";
    $.ajax({
        type: "POST",
        url: codeDictUrl + cateCode,
        dataType: "json",
        async: false,
        success: function (msg) {
            $.each(msg, function (i, item) {
                result = result + "{id:'" + item.ctgryItemCde + "',text:'" + item.ctgryItemNmeCn + "'},";
            });
            result = result.substring(0, result.length - 1) + "]";
        }
    });
    return result;
};

/**
 * 生成伪业务参考号
 * @param {type} busiType 业务模块
 * @returns {String}\
 */
var makeTempNo = function(busiType){
    if(busiType){
    }else{
        busiType = "TEMP";
    }
    return busiType + myDateUtil.formatCurrentDate().replace(/[ -/:]/g,"");
};