<%--
  Created by IntelliJ IDEA.
  User: BF100
  Date: 2017/11/2
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="lineChartDiv" style="width:100%;"></div>
</body>
</html>

<script type="text/javascript">
    window.onload = function () {
//        $("body").css("background","none").css("background-color","#161616");
        var lineChartHeight = $(window).height() - 529;
        //var barChartHeight = ($(window).height() - 218) * (1/3);
        $("#lineChartDiv").css("height",lineChartHeight);
        //读取走势图
        getLineChartData();
        window.setInterval("getLineChartData()",300000);
        alert("hello word");
    }

    var lineChart;
    //读取走势图数据
    var readFisrt = false;
    function getLineChartData() {
        //
        sendRequest("${ctx}/fileOs/getColumnChart.do", {
            reveal_id : 1
        }, function(data) {
            if(data.retCode == 1) {
                if(!readFisrt) {
                    showLineChart(data);
                } else {
                    lineChart.dataProvider = data.lineChartResult.resultList;
                    lineChart.validateData();
                }
            } else {
                $("#lineChartDiv").html(data.retMsg);
            }
        });
        checkToday();
    }

    function showLineChart(data) {
        readFisrt = true;
        // SERIAL CHART
        lineChart = new AmCharts.AmSerialChart();
        lineChart.fontSize = 25;
        lineChart.color = "#FFFFFF";
        lineChart.dataProvider = data.lineChartResult.resultList;
        lineChart.categoryField = "lineChartX";
        lineChart.startDuration = 0.5;
        lineChart.balloon.color = "#000000";

        // AXES
        // category
        var categoryAxis = lineChart.categoryAxis;
        categoryAxis.autoGridCount = true;
        categoryAxis.labelFrequency = 2;	//X显示间隔
        categoryAxis.gridColor = "#FFFFFF";
        categoryAxis.axisColor = "#555555";

        // value
        var valueAxis = new AmCharts.ValueAxis();
        valueAxis.integersOnly = true;
        valueAxis.axisColor = "#555555";
        lineChart.addValueAxis(valueAxis);

        // GRAPHS
        for(var i=0;i<data.lineChartResult.groupNames.length;i++) {
            var groupName = data.lineChartResult.groupNames[i];
            var graph = new AmCharts.AmGraph();
            graph.title = groupName;
            graph.valueField = groupName;
            graph.labelText = "[[value]]";
            graph.bullet = "round";
            graph.fontSize = 40;
            graph.bulletSize = 10;
            graph.lineThickness = 4;
            if(groupName == "昨日") {
                graph.lineColor = "#587ca0";
                graph.labelText = "";
            } else if(groupName == "上周") {
                graph.lineColor = "#f7a400";
                graph.labelText = "";
            } else {
                graph.lineColor = "#3cbfea";
                graph.labelText = "[[lineChartY2]]";
                graph.labelPosition = "right";
            }
            lineChart.addGraph(graph);
        }

        // LEGEND
        var legend = new AmCharts.AmLegend();
        legend.color = "#FFFFFF";
        legend.position = "right";
        legend.fontSize = 40;
        lineChart.addLegend(legend);

        // WRITE
        lineChart.write("lineChartDiv");
    }

    /**
     * @param requsetUrl 访问地址
     * @param paramData 访问参数
     * @param callback 回调函数
     */
    function sendRequest(requsetUrl, paramData, callback, blockUIFlag) {
        if (blockUIFlag==null || blockUIFlag == undefined || blockUIFlag==true) {
            loadJs();
        }
        $.ajax({
            cache: false,
            type: "post",
            url: requsetUrl + "?timestamp=" + new Date().getTime(),
            data: paramData,
            success: function (back) {
                try {

                    callback(back);
                } catch (e) {

                }
                closeBlockUI();
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                closeBlockUI();
            }
        });
    }
    function loadJs() {
        try {
            $.blockUI({
                css: {
                    border: 'none',
                    padding: '15px',
                    backgroundColor: '#000',
                    '-webkit-border-radius': '10px',
                    '-moz-border-radius': '10px',
                    opacity: .5,
                    color: '#fff'
                }
            });
        } catch (e) {

        }
    }
    function closeBlockUI() {
        $(".blockUI").remove();
    }

    //判断当前时间是否为已过今日
    //
    var nowDate = new Date();
    var today = nowDate.getFullYear()+"-"+(nowDate.getMonth()+1)+"-"+nowDate.getDate();;
    function checkToday() {
        var nowDate2 = new Date();
        var now = nowDate2.getFullYear()+"-"+(nowDate2.getMonth()+1)+"-"+nowDate2.getDate();
        if(today != now) {
            location.reload();
        }
    }
</script>
