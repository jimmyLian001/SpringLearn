package com.jimmy.model;


/**
 * 门户展示结果对象
 *
 * @author zhour
 */
public class AdminRevealResultModel extends BaseModel {
    private BarChartPluginListEntity barChartResult;
    private LineChartPluginListEntity lineChartResult;
    private SmallChartPluginEntity smallChartResult;

    public BarChartPluginListEntity getBarChartResult() {
        return barChartResult;
    }

    public void setBarChartResult(BarChartPluginListEntity barChartResult) {
        this.barChartResult = barChartResult;
    }

    public LineChartPluginListEntity getLineChartResult() {
        return lineChartResult;
    }

    public void setLineChartResult(LineChartPluginListEntity lineChartResult) {
        this.lineChartResult = lineChartResult;
    }

    public SmallChartPluginEntity getSmallChartResult() {
        return smallChartResult;
    }

    public void setSmallChartResult(SmallChartPluginEntity smallChartResult) {
        this.smallChartResult = smallChartResult;
    }
}
