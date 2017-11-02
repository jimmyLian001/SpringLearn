package com.jimmy.model;

import java.util.List;
import java.util.Map;

/**
 * 小型图表插件对象
 *
 * @author zhour
 */
public class SmallChartPluginEntity {
    private List<Map<String, Object>> smallResultList;
    private String bigColor;    //主标签颜色
    private String smallColor;    //副标签颜色

    //
    public List<Map<String, Object>> getSmallResultList() {
        return smallResultList;
    }

    public void setSmallResultList(List<Map<String, Object>> smallResultList) {
        this.smallResultList = smallResultList;
    }

    public String getBigColor() {
        return bigColor;
    }

    public void setBigColor(String bigColor) {
        this.bigColor = bigColor;
    }

    public String getSmallColor() {
        return smallColor;
    }

    public void setSmallColor(String smallColor) {
        this.smallColor = smallColor;
    }

}
