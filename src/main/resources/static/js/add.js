define(function (require, exports, module) {

    var $ = require('jquery');

    /*获取参数*/
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

    /*发起请求*/
    var getData = function () {
        $.ajax({
            url: './content/add',
            type: 'post',
            data: getParam(),
            dataType: 'json',
            success: function (data) {
                alert("添加成功！");
                cleanData();
            },
            error: function (data) {
                alert("添加失败！")
            }
        });
    };

    exports.add = function () {
        getData();
    }
});