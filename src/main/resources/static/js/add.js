define(function (require, exports, module) {

    var AjaxUtil = require('./util/AjaxUtil.js');
    var AddClassBox = require('./util/AddClassBox.js');
    var HandlebarsUtil = require('./util/HandlebarsUtil.js');

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
        }, function (data) {
            alert("添加失败！")
        })
    };

    /*查询下拉选*/
    var queryChoose = function () {
        var url = './content/queryClass';
        AjaxUtil.ajaxGet(url, null, function (data) {
            var html = HandlebarsUtil.render('choose-template', data);
            $('#contentClass').append(html);
        }, function () {
            alert('分类查询异常！')
        })
    }

    $(function () {
        AddClassBox.getAddClassBox();
        queryChoose();
    });

    exports.add = function () {
        submitData();
    }
});