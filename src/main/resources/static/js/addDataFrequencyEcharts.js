define(function (require, exports, module) {

    require('./dist/echarts.min.js');
    var AjaxUtil = require('./util/AjaxUtil.js');


    //重构数据
    var reconstruct = function (data) {
        var itemName = [];
        var itemValue = [];
        data.forEach(function (e) {
            itemName.push(e.name);
            itemValue.push(e.num);
        });
        return {
            itemName: itemName,
            itemValue: itemValue
        }
    };

    //展示数据
    var showFreqEcharts = function (data) {
        var contentClassChart = echarts.init(document.getElementById('addFrequencyDiv'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '添加数据的频率'
            },
            tooltip: {},
            legend: {
                data: ['条数']
            },
            xAxis: {
                data: data.itemName
            },
            yAxis: {},
            series: [{
                name: '条数',
                type: 'bar',
                data: data.itemValue
            }]
        };

        contentClassChart.setOption(option);
    };
    //获取添加数据的日期
    var getAddDate = function () {
        AjaxUtil.ajaxGet('./index/queryModifyFruquery', null, function (data) {
            data = reconstruct(data);
            showFreqEcharts(data);
        })
    };


    return {
        getAddDate: getAddDate
    }

});