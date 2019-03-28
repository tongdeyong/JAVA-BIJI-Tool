define(function (require, exports, module) {

    var AjaxUtil = require('ajaxUtil');
    var AddClassBox = require('AddClassBox');

    /**获取参数*/
    var getParam = function () {
        return param = {
            'contentClass': $('#contentClass').val(),
            'parentTitle': $('#parentTitle').val(),
            'subheading': $('#subheading').val(),
            'description': $('#description').val()
        };
    };

    /**
     * 清空输入框
     */
    var cleanData = function () {
        $('#subheading').val('');
        $('#description').val('');
    };

    /**提交添加的信息*/
    var submitData = function () {
        var url = './content/add';
        var data = getParam();
        AjaxUtil.ajaxPost(url, data, function (data) {
            alert('添加成功！');
            cleanData();
        }, function () {
            alert("添加失败！")
        })
    };

    $(function () {
        AddClassBox.getAddClassBox();
    });

    exports.add = function () {
        submitData();
    }
});