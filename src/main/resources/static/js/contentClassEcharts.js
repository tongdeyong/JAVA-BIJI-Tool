define(function (require, exports, module) {

    require('./dist/echarts.min.js');
    var AjaxUtil = require('./util/AjaxUtil.js');


    //重构分类的数据
    var reconstructData = function (data) {
        var legendData = [];
        var seriesData = [];
        data.forEach(function (e) {
            legendData.push(e.name);
            var item = {
                value: e.num,
                name: e.name
            };
            seriesData.push(item);
        });
        return {
            legendData: legendData,
            seriesData: seriesData
        }
    };


    var showEchart = function (data) {

        //2. 基于准备好的dom，初始化echarts实例
        var contentClassChart = echarts.init(document.getElementById('contentClassDataDiv'));
        //3. 指定图表的配置项和数据
        var option = {
            title: {
                text: '已收集的数据的类别',
                subtext: '数据来源于分类选项个数',
                x: 'center'
            },
            tooltip: {
                trigger: 'item',
                formatter: "{a} <br/>{b} : {c} ({d}%)"
            },
            legend: {
                orient: 'vertical',
                left: 'left',
                data: data.legendData
            },
            series: [
                {
                    name: '分类',
                    type: 'pie',
                    radius: '55%',
                    center: ['50%', '60%'],
                    data: data.seriesData,
                    itemStyle: {
                        emphasis: {
                            shadowBlur: 10,
                            shadowOffsetX: 0,
                            shadowColor: 'rgba(0, 0, 0, 0.5)'
                        }
                    }
                }
            ]
        };
        //4. 使用刚指定的配置项和数据显示图表。
        contentClassChart.setOption(option);
    };

    //查询分类信息
    var getClassData = function () {
        AjaxUtil.ajaxGet('./index/queryClass', null, function (data) {
            data = reconstructData(data);
            showEchart(data);
        }, function () {
            alert('系统异常！')
        })
    };

    return {getClassData: getClassData}

});