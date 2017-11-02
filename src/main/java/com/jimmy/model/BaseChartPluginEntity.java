package com.jimmy.model;

import com.jimmy.Util.DBUtil;
import com.jimmy.Util.DateExtendUtil;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.Map;

public class BaseChartPluginEntity {
    //图表链接URL
    private String plugin_link;

    //
    public String getPlugin_link() {
        return plugin_link;
    }

    public void setPlugin_link(String plugin_link) {
        this.plugin_link = plugin_link;
    }

    //获取数据挖掘链接
    public void wrapDrillingUrl(boolean flagDrilling, Map<String, Object> entityMap) {
        //数据挖掘-select_target_ids
        String target_id = DBUtil.getDBString(entityMap.get("drilling_target_id"));
        //数据挖掘-select_item_id
        String item_id = DBUtil.getDBString(entityMap.get("drilling_item_id"));
        //数据挖掘-begin_date
        String begin_date = DBUtil.getDBString(entityMap.get("drilling_begin_date"));
        if (StringUtils.isBlank(begin_date)) {
            begin_date = DateExtendUtil.getNowSmallDate();
        }
        //数据挖掘-end_date
        String end_date = DBUtil.getDBString(entityMap.get("drilling_end_date"));
        if (StringUtils.isBlank(end_date)) {
            end_date = DateExtendUtil.getNowSmallDate();
        }
        this.plugin_link = "data/drilling/drillingManager.do?select_target_ids=" + target_id + "&select_item_id=" + item_id + "&begin_date=" + begin_date + "&end_date=" + end_date;
    }

    //
    public void wrapPluginLink(String plugin_link, List<String> linkParams, Map<String, Object> entityMap) {
        for (String param : linkParams) {
            String paramValue = DBUtil.getDBString(entityMap.get(param));
            plugin_link = plugin_link.replace("[" + param + "]", paramValue);
        }
        this.plugin_link = plugin_link;
    }
}
