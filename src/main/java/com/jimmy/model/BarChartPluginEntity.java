package com.jimmy.model;

import java.math.BigDecimal;

/**
 * 柱状图插件模板对象
 *
 * @author zhour
 */
public class BarChartPluginEntity extends BaseChartPluginEntity {
    //
    private String barChartX;                //x轴数据，表示柱状图名称
    private BigDecimal barChartY;            //y轴数据，表示柱状图值
    private String color;
    private String barGroupName;                //分类名称

    //
    public String getBarChartX() {
        return barChartX;
    }

    public void setBarChartX(String barChartX) {
        this.barChartX = barChartX;
    }

    public BigDecimal getBarChartY() {
        return barChartY;
    }

    public void setBarChartY(BigDecimal barChartY) {
        this.barChartY = barChartY;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBarGroupName() {
        return barGroupName;
    }

    public void setBarGroupName(String barGroupName) {
        this.barGroupName = barGroupName;
    }
}
