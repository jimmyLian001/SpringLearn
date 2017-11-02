package com.jimmy.model;

import java.util.List;
import java.util.Map;

public class ColumnStackedListEntity {
    private List<Map<String, Object>> resultList;        //结果集
    private List<String> groupNames;                    //分组名
    private List<String> groupColors;                    //分组颜色

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
}
