package com.jimmy.model;

import java.math.BigDecimal;

public class PyramidChartPluginEntity extends BaseChartPluginEntity {
    private String label;
    private BigDecimal value;
    private String link;

    //
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


}
