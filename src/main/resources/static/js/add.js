define(function (require, exports, module) {

    var $ = require('jquery');
    var getParam = function () {
        return param = {
            'contentClass': $('#contentClass').val(),
            'parentTitle': $('#parentTitle').val(),
            'subheading': $('#subheading').val(),
            'description': $('#description').val()
        };
    };

    var getData = function () {

        console.log(getParam());
        $.ajax({
            //url: '${pageContext.request.contextPath}/content/add',
            url: 'http://localhost:9999/content/add',
            type: 'post',
            data: getParam(),
            dataType: 'json',
            success: function (data) {
                alert("添加成功！")
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