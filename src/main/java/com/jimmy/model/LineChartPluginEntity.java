package com.jimmy.model;

import java.math.BigDecimal;

public class LineChartPluginEntity extends BaseChartPluginEntity {
    //
    private String lineChartX;                //x轴数据，表示折线图名称
    private BigDecimal lineChartY;            //y轴数据，表示折线图值
    private String lineGroupName;            //分类名称
    private String color;

    //
    public String getLineChartX() {
        return lineChartX;
    }

    public void setLineChartX(String lineChartX) {
        this.lineChartX = lineChartX;
    }

    public BigDecimal getLineChartY() {
        return lineChartY;
    }

    public void setLineChartY(BigDecimal lineChartY) {
        this.lineChartY = lineChartY;
    }

    public String getLineGroupName() {
        return lineGroupName;
    }

    public void setLineGroupName(String lineGroupName) {
        this.lineGroupName = lineGroupName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
