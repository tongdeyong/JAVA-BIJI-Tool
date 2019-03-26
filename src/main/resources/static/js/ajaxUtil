//ajax工具类
define(function (require, exports, module) {

    var $ = require('jquery');

    var getParam = {};

    var ajaxPost = function (url, data) {
        $.ajax({
            url: url,
            type: 'post',
            data: data,
            dataType: 'json',
            success: function (data) {

            },
            error: function (data) {

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
            error: function (data) {
                error(data);
            }
        })
    }

});