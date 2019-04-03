define(function (require, exports, module) {

    require('./util/jquery.base64.js');
    var $ = jQuery;
    var AjaxUtil = require('./util/AjaxUtil.js');
    var HandlebarsUtil = require('./util/HandlebarsUtil.js');

    //当提交按钮显示为编辑时，走编辑
    var editData = function () {
        //改标题
        $('H2').text('编辑信息');
        //大标题
        $('#parentTitle').removeAttr('disabled');
        //小标题
        $('#subheading').removeAttr('disabled');
        //详情
        $('#description').removeAttr('disabled');
        //按钮提交变成编辑
        $('#add-buttons').text('提交');
        //添加分类按钮隐藏
        $('#add-class-button').show();
    };

    /*显示当前选项*/
    var chooseOptionToShow = function (contentClass) {
        var url = './content/queryClass';
        AjaxUtil.ajaxGet(url, null, function (data) {
            data = $.grep(data, function (val, index) {
                return val !== contentClass;
            });
            var html = HandlebarsUtil.render('choose-template', data);
            $('#contentClass').append(html);
        }, function () {
            alert('分类查询异常！')
        });
    };

    /*显示详细信息*/
    function detailToShow(getDetailData) {
        //插入数据
        //分类
        $('#contentClass').append('<option>' + getDetailData.contentClass + '</option>');
        chooseOptionToShow(getDetailData.contentClass);
        //大标题
        $('#parentTitle').val(getDetailData.parentTitle).attr("disabled", "disabled");
        //小标题
        $('#subheading').val(getDetailData.subheading).attr("disabled", "disabled");
        //详情
        $('#description').val(getDetailData.description).attr("disabled", "disabled");
        //添加分类按钮隐藏
        $('#add-class-button').hide();
        //id放入
        $('#idValue').val(getDetailData.id);
    }

    var dataToShow = function () {
        var url = decodeURI(window.location.href);
        var argIndex = url.split('?');
        var detailData = argIndex[1].split('=');
        var content = JSON.parse($.base64.decode(detailData[1], 'uft8'));
        detailToShow(content);
        if (detailData[0] === 'edit') {
            editData();
        }

    };

    return {
        editData: editData,
        dataToShow: dataToShow
    }
});