define(function (require, exports, module) {

    var AjaxUtil = require('./util/AjaxUtil.js');
    var HandlebarsUtil = require('./util/HandlebarsUtil.js');

    /*查询所有信息*/
    var queryAllData = function () {
        var url = './content/selectAll';
        AjaxUtil.ajaxGet(url, null, function (data) {
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
    }

    /*删除一条信息*/
    var deleteOne = function () {
        $(document).on('click', 'button[name="delete"]', function () {
            if (window.confirm('确认要删除此条信息？')) {
                var id = $(this).attr('no');
                deleteOneData(id);
            }
        });
    }

    /**
     * 关键字搜索
     * 若搜索框内有字，则查找关键字，若无，则搜索全部
     */
    var queryData = function () {
        $('#query-button').click(function () {
            var param = $('#query').val();
            if (param) {
                AjaxUtil.ajaxGet('./content/queryByWord', param, function (data) {
                    if (data) {
                        var html = HandlebarsUtil.render('select-template', data);
                        $('#resultTable').html(html);
                    } else {
                        alert('sorry!未查到相关信息！');
                    }
                }, function () {
                    alert('系统异常！')
                })
            } else {
                queryAllData();
            }
        });

    }

    var queryfun = function () {
        queryAllData();
        deleteOne();
        queryData();
    }

    return {
        queryfun: queryfun
    }

});