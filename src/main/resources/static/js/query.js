define(function (require, exports, module) {

    var AjaxUtil = require('./util/AjaxUtil.js');
    require('./util/jquery.base64.js');
    var $ = jQuery;
    var HandlebarsUtil = require('./util/HandlebarsUtil.js');
    var Add = require('./add.js');

    /**重构查询的数据，主要对详情内容进行截取*/
    var constructData = function (data) {
        if (data) {
            data.forEach(function (item) {
                item.base64Data = $.base64.encode(JSON.stringify(item), 'utf8');
                var detailData = item.description;
                if (detailData && detailData.length > 20) {
                    item.description = detailData.substring(0, 20) + '...';
                }
            })
        }
        return data;
    };

    /*查询所有信息*/
    var queryAllData = function () {
        var url = './content/selectAll';
        AjaxUtil.ajaxGet(url, null, function (data) {
            data = constructData(data);
            var html = HandlebarsUtil.render('select-template', data);
            $('#resultTable').html(html);
        }, function () {
            alert("系统异常！");
        });
    };

    /*删除一条信息请求*/
    var deleteOneData = function (id) {
        var url = './content/deleteOne/' + id;
        AjaxUtil.ajaxGet(url, null, function (backData) {
            if (backData === true) {
                alert('删除成功！');
                queryAllData();
            } else {
                alert(backData);
            }
        }, function () {
            alert("系统异常！");
        });
    };

    /*删除一条信息*/
    var deleteOne = function () {
        $(document).on('click', 'button[name="delete"]', function () {
            if (window.confirm('确认要删除此条信息？')) {
                var id = $(this).attr('no');
                deleteOneData(id);
            }
        });
    };

    /**
     * 关键字搜索
     * 若搜索框内有字，则查找关键字，若无，则搜索全部
     */
    var queryData = function () {
        $('#query-button').click(function () {
            var param = {
                'contentClass': $('#contentClass').val(),
                'parentTitle': $('#queryTitle').val(),
                'subheading': $('#querySubTitle').val()
            };

            AjaxUtil.ajaxGet('./content/queryByWord', param, function (data) {
                if (data) {
                    data = constructData(data);
                    var html = HandlebarsUtil.render('select-template', data);
                    $('#resultTable').html(html);
                } else {
                    alert('sorry!未查到相关信息！');
                }
            }, function () {
                alert('系统异常！')
            })
        });

    };


    /*查看详情*/
    var showDetail = function () {
        $(document).on('click', 'button[name="detail"]', function () {
            var getDetailData = $(this).attr('detail');
            if (getDetailData) {
                var url = encodeURI('detail?detail=' + getDetailData);
                //调出详情页面
                window.open(url);
            } else {
                alert('系统出错！')
            }
        })

    };

    /*编辑信息，先显示详情，再将状态变为可编辑*/
    var editDetailData = function () {
        $(document).on('click', 'button[name="modify"]', function () {
            var getDetailData = $(this).prev().attr('detail');
            if (getDetailData) {
                var url = encodeURI('detail?edit=' + getDetailData);
                //调出详情页面
                window.open(url);
            } else {
                alert('系统出错！')
            }
        });

    };

    var queryFun = function () {
        Add.queryChoose();
        queryAllData();
        deleteOne();
        queryData();
        showDetail();
        editDetailData()
    };

    return {
        queryFun: queryFun
    }

});