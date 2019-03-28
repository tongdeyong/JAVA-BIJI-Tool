/*添加分类的弹窗*/
define(function (require, exports, module) {

    var AjaxUtil = require('ajaxUtil');

    var showAddClassBox = function () {
        $('#add-class-button').click(function () {
            $('.classpopBox').show();
            $('.classpopLayer').show();
        })
    };

    var hideAddClassBox = function () {
        $('#cancle,.classpopBox .classclose a').on('click', function () {
            $('.classpopBox').hide();
            $('.classpopLayer').hide();
            $('#addClass').val('');
        });
    };

    var addClass = function () {
        $('#confirm').click(function () {
            var param = $('#addClass').val();
            var url = './content/addClass';
            AjaxUtil.ajaxGet(url, param, function () {
                $('#addResult').val('添加成功！')
            }, function () {
                $('#addResult').val('添加失败！');
                $('#addResult').attr({'font-color': 'red'});
            })
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