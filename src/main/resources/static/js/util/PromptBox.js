/*弹框插件*/
define(function (require, exports, module) {

    var box_param;
    /*box的默认参数*/
    //弹出框参数基本分为3个部分，宽高、信息提示、确认与取消按钮
    /*var getParam = function (width, height, title, message, hasConfirmButt, hasCancleButt) {
        box_param = {
            width: width || 400,
            height: height || 300,
            title: title || '',
            message: message || '',
            hasConfirmButt: hasConfirmButt || true,    //是否有确认按钮
            hasCancleButt: hasCancleButt || true     //是否有取消按钮
        };
    };*/

    var getParam = function (width, height, title, message, hasConfirmButt, hasCancleButt) {
        box_param = {
            width: 400,
            height: 300,
            title: '',
            message:  '',
            hasConfirmButt: true,    //是否有确认按钮
            hasCancleButt: true     //是否有取消按钮
        };
    };

    //关闭弹窗
    var hideBox = function () {
        $('#promptBox').hide();
    };

    //关闭弹窗
    var closeBox = function () {
        $('#promptBox_confirmButtn').on('click', function () {
            hideBox();
        });
    };

    /*构建基本窗口*/
    var showBasicWindow = function () {
        var $window;
        var box = $('#promptBox');
        if (box.length > 1) {
            $window = box;
        } else {
            $window = '<div id="promptBox" class="box-panel">' +
                '<div id="promptBox_title" style="height: 20px"></div>' +
                '<div id="promptBox_message"></div>' +
                '</div>';
            $('body').append($($window));
        }
        //清楚掉内部的内容，如果该窗口已经存在，内部的内容必须清掉，便于建立新的内容，
        // 如果已经存在弹出窗口，很有可能弹出窗口已经隐藏了，因此，需要显示
        //目前只能固定在窗口中间
        box.empty().show().css({position: 'fixed'});
        box.css('width', box_param.width);
        box.css('height', box_param.height);
        $('#promptBox_title').val(box_param.title);
        var mssage_box = $('#promptBox_message');
        mssage_box.val(box_param.message);
        if (box_param.hasConfirmButt || box_param.hasCancleButt) {
            var confirmDiv = '<div id="promptBox_confirm" style="height: 40px">' +
                '<div id="promptBox_confirmButtn">确认</div>' +
                '<div id="promptBox_cancleButtn">取消</div>' +
                '</div>';
            mssage_box.after($(confirmDiv));
            var message_height = box.height - $('#promptBox_title').height - $('#promptBox_confirm').height;
            mssage_box.css('height', message_height);
        }
        closeBox();
    };


    /*显示弹窗*/
    var showBox = function () {
        getParam();
        showBasicWindow();
    };

    return {
        showBox: showBox,
        hideBox: hideBox
    };
});