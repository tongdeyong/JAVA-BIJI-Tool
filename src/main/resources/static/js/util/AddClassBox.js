/*添加分类的弹窗*/
define(function (require, exports, module) {

    var AjaxUtil = require('./AjaxUtil.js');

    /*显示分类选项弹框*/
    var showAddClassBox = function () {
        $('#add-class-button').click(function () {
            $('.classpopBox').show();
            $('.classpopLayer').show();
        })
    };

    /*关闭添加分类弹框*/
    var hideAddClassBox = function () {
        $('#cancle,.classpopBox .classclose a').on('click', function () {
            $('.classpopBox').hide();
            $('.classpopLayer').hide();
            $('#addClass').val('');
            $('#addResult').text('');
        });
    };

    /*添加分类选项*/
    var addClass = function () {
        $('#confirm').click(function () {
            var param = $('#addClass').val();
            $('#contentClass').append(
                '<option selected>' + param + '</option>'
            )
            $('#addResult').text('添加成功！')
            $('#addClass').val('');
        });
    };

    var getAddClassBox = function () {
        showAddClassBox();
        hideAddClassBox();
        addClass();
    };

    return {
        getAddClassBox: getAddClassBox
    }
});