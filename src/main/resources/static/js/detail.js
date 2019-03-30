define(function (require, exports, module) {

    require('./util/jquery.base64.js');
    var $ = jQuery;

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
    var chooseOptionToSHow = function (contentClass) {
        $('#contentClass option').each(function () {
            console.log($(this).val());
            if ($(this).val() === contentClass) {
                $(this).attr('selected', true);
            }
        })
    };

    /*显示详细信息*/
    var detailToShow = function (getDetailData) {
        //插入数据
        //分类
        chooseOptionToSHow(getDetailData.contentClass);
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
    };

    var dataToShow = function () {
        var url = decodeURI(window.location.href);
        var argIndex = url.split('?data=');
        var detailData = argIndex[1];
        detailData = JSON.parse($.base64.decode(detailData, 'uft8'));
        detailToShow(detailData);
    };

    return {
        editData: editData,
        dataToShow: dataToShow
    }
});