define(function (require, exports, module) {

    var $ = require('jquery');
    var ajaxUtil = require('ajaxUtil');
    var promptBox = require('promptBox');
    var handlebarsUtil = require('handlebarsUtil');
    //var Handlebars = require('./dist/handlebars-v4.1.1.js');
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
        ajaxUtil.ajaxPost(url, data, function (data) {

            cleanData();
        }, function (data) {
            alert("添加失败！")
        })
    };



    /*点击关闭按钮*/
    function closeBox() {
        var popBox = document.getElementById("popBox");
        var popLayer = document.getElementById("popLayer");
        popBox.style.display = "none";
        popLayer.style.display = "none";
    }

    exports.add = function () {
        submitData();
    }
});