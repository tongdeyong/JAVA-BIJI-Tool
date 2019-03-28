/*弹框插件*/
define(function (require, exports, module) {

    var HandlebarsUtil = require('./HandlebarsUtil.js');


    /*建一个基本弹窗*/
    var buildDialogBox = function (templateId, msg) {
        var data = {'data':msg};
        if ($('.popBox').length > 0) {
            $('.popBox').show();
            $('.popLayer').show();
        } else {
            var html = HandlebarsUtil.render(templateId, data);
            $('body').append(html);
        }
    };

    /**
     * 关闭弹窗
     */
    var closeBox = function () {
        $('.popBox').hide();
        $('.popLayer').hide();
    };

    /**
     * 创建一个弹窗
     *
     * @param templateId 模板ID
     * @param data 弹窗中要显示的内容
     * 现有类型：1.success
     *         2.error
     *         3.confirm
     */
    var newDialogBox = function (templateId, msg) {
        buildDialogBox(templateId, msg);
        $('#cancle').hide();
        $('#confirm').on('click', function () {
            closeBox();
        });

    };

    return {
        newDialogBox: newDialogBox,
        closeBox: closeBox
    }

});