package com.jimmy.model;


import java.io.Serializable;

//@AnnoEntity(table = "BAOFOO_ADMIN.admin_plugin_table")
public class AdminPluginTable implements Serializable {
//    //SQL标签
//    public static final String SQL_LABEL_SORT = "[排序标签]";
//
//    /**
//     *
//     */
//    private static final long serialVersionUID = -1104468084464594369L;
//    @AnnoId
//    @AnnoColum(name = "插件列表ID")
    private int plugin_id;
    private String table_name;
    private String table_param;
    private String table_width;
    private int table_total;
    private int table_layout;
    private int table_format;
    private String table_hyperlink;

    //
    public int getPlugin_id() {
        return plugin_id;
    }

    public void setPlugin_id(int plugin_id) {
        this.plugin_id = plugin_id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getTable_param() {
        return table_param;
    }

    public void setTable_param(String table_param) {
        this.table_param = table_param;
    }

    public String getTable_width() {
        return table_width;
    }

    public void setTable_width(String table_width) {
        this.table_width = table_width;
    }

    public String getTable_hyperlink() {
        return table_hyperlink;
    }

    public void setTable_hyperlink(String table_hyperlink) {
        this.table_hyperlink = table_hyperlink;
    }

    public int getTable_total() {
        return table_total;
    }

    public void setTable_total(int table_total) {
        this.table_total = table_total;
    }

    public int getTable_layout() {
        return table_layout;
    }

    public void setTable_layout(int table_layout) {
        this.table_layout = table_layout;
    }

    public int getTable_format() {
        return table_format;
    }

    public void setTable_format(int table_format) {
        this.table_format = table_format;
    }

}
