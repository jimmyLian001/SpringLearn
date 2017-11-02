package com.jimmy.model;


public class BaseModel {
    public static final int OK = 1;
    public static final int ERROR = 0;
    public static final String USABLE = "USABLE";
    public static final String UN_USABLE = "UN_USABLE";
    private int retCode;// 请求返回状态 1 为成功 0 为失败
    private String retMsg;// 返回信息
    private Object obj;    //返回值。
    private String htmlTitle = "宝付科技"; // 页面标题

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public BaseModel() {
        super();
    }

    public BaseModel(int retCode, String retMsg) {
        super();
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public BaseModel(int retCode, String retMsg, Object obj) {
        super();
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.obj = obj;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getHtmlTitle() {
        return htmlTitle;
    }

    public void setHtmlTitle(String htmlTitle) {
        this.htmlTitle = htmlTitle;
    }

}
