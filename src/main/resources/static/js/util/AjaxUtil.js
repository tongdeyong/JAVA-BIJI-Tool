//ajax工具类
define(function (require, exports, module) {

    var ajaxPost = function (url, data, success, error) {
        $.ajax({
            url: url,
            type: 'post',
            data: data,
            dataType: 'json',
            success: function (data) {
                success(data);
            },
            error: function () {
            }
        })
    };
    var ajaxGet = function (url, data, success, error) {
        $.ajax({
            url: url,
            type: 'get',
            data: data,
            dataType: 'json',
            success: function (data) {
                success(data);
            },
            error: function () {
            }
        })
    };

    return {
        ajaxGet: ajaxGet,
        ajaxPost: ajaxPost
    }
});