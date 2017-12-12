package com.jimmy.model;

import java.util.List;

public class CommonTablePluginEntity {
    private List<AdminPluginTable> pluginTables;
    private List<String> tableResult;
    private boolean tableSortFlag;

    //
    public List<AdminPluginTable> getPluginTables() {
        return pluginTables;
    }

    public void setPluginTables(List<AdminPluginTable> pluginTables) {
        this.pluginTables = pluginTables;
    }

    public List<String> getTableResult() {
        return tableResult;
    }

    public void setTableResult(List<String> tableResult) {
        this.tableResult = tableResult;
    }

    public boolean isTableSortFlag() {
        return tableSortFlag;
    }

    public void setTableSortFlag(boolean tableSortFlag) {
        this.tableSortFlag = tableSortFlag;
    }


}
