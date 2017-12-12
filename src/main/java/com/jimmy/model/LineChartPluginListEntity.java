package com.jimmy.model;

import java.util.List;
import java.util.Map;

public class LineChartPluginListEntity {
    private List<Map<String, Object>> resultList;        //结果集
    private List<String> groupNames;                    //分组名
    private List<String> groupColors;                    //分组颜色
    private String defaultHideLegend;                    //默认隐藏
    private boolean flagHyperlink;                        //是否启用超链接

    //
    public List<Map<String, Object>> getResultList() {
        return resultList;
    }

    public void setResultList(List<Map<String, Object>> resultList) {
        this.resultList = resultList;
    }

    public List<String> getGroupNames() {
        return groupNames;
    }

    public void setGroupNames(List<String> groupNames) {
        this.groupNames = groupNames;
    }

    public List<String> getGroupColors() {
        return groupColors;
    }

    public void setGroupColors(List<String> groupColors) {
        this.groupColors = groupColors;
    }

    public String getDefaultHideLegend() {
        return defaultHideLegend;
    }

    public void setDefaultHideLegend(String defaultHideLegend) {
        this.defaultHideLegend = defaultHideLegend;
    }

    public boolean isFlagHyperlink() {
        return flagHyperlink;
    }

    public void setFlagHyperlink(boolean flagHyperlink) {
        this.flagHyperlink = flagHyperlink;
    }


}
