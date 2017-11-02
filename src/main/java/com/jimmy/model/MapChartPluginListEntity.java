package com.jimmy.model;

import java.util.List;


public class MapChartPluginListEntity {
    private List<MapChartPluginEntity> mapChartPluginList;
    private List<MapGroupTypeEntity> pluginGroupList;
    private int mapChartGroupType;        //选择序列方式

    //
    public List<MapChartPluginEntity> getMapChartPluginList() {
        return mapChartPluginList;
    }

    public void setMapChartPluginList(List<MapChartPluginEntity> mapChartPluginList) {
        this.mapChartPluginList = mapChartPluginList;
    }

    public List<MapGroupTypeEntity> getPluginGroupList() {
        return pluginGroupList;
    }

    public void setPluginGroupList(List<MapGroupTypeEntity> pluginGroupList) {
        this.pluginGroupList = pluginGroupList;
    }

    public int getMapChartGroupType() {
        return mapChartGroupType;
    }

    public void setMapChartGroupType(int mapChartGroupType) {
        this.mapChartGroupType = mapChartGroupType;
    }

}
