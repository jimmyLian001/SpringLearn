;
(function($){
    $.FormUtils = $.FormUtils || {};
    $.extend($.FormUtils, {
    
        /**
         * 清空表单查询条件
         * @param {type} selector
         * @returns {undefined}
         */
        resetForm: function(selector){
            $("#"+selector)[0].reset();
            //清楚隐藏域
            $("#"+selector).find('input[type=hidden]').each(function(){
                this.value = '';
            });
            //下拉列表
        }
    });
})(jQuery);

/**
 * 序列化form表单中的查询条件，转化为json格式
 * @returns {"userName":"1234","companyName":"3232323","userCode":"2323232434343"}
 */
$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] != undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            if (this.value != null && this.value != '' && this.value.length > 0) {
                o[this.name].push(this.value);
            }
        } else {
            if (this.value != null && this.value != '' && this.value.length > 0) {
                o[this.name] = this.value;
            }
        }
    });
    return o;
};
