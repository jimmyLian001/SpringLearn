package com.jimmy.Util;

public final class ConstUtil {
    public static String EMPTY = "";
    public static String NEW_LINE = "\n";
    //
    public static String SPLIT_MH = ":";
    public static String SPLIT_WH = "?";
    public static String SPLIT_EQUAL = "=";
    public static String SPLIT_FH = ";";
    public static String SPLIT_XHX = "_";
    public static String SPLIT_AND = "&";
    public static String SPLIT_DH = ",";
    public static String SPLIT_2 = "->";
    public static String SPLIT_BLANK = " ";
    public static String SPLIT_BFH = "%";
    public static String SPLIT_SH = "|";
    public static String SPLIT_HX = "-";
    public static final String FLAG = "1";

    /**
     * 日志使用
     */
    public static final String TRACE_LOG_ID = "tracelogid";

    /**
     * 错误信息返回
     */
    public static final String ERROR_MSG = "errorMsg";

    /**
     * 分页返回信息
     */
    public static final String PAGE_INFO = "basePage";

    /**
     * 返回页面信息参数名称
     */
    public static final String PAGE_PARAM = "bean";

    /**
     * 成功状态
     */
    public final static String SUCCESS_FLAG = "000000";

    /**
     * 失败状态
     */
    public final static String FAILED_FLAG = "999999";

    /**
     * 系统内部异常，请稍后重试
     */
    public final static String SYSTEM_ERROR_MSG = "系统内部异常，请稍后重试";

    /**
     * 返回前端信息
     */
    public final static String ERROR_CODE = "errorCode";

    /**
     * admin系统在redis保存的redis key前缀
     */
    public final static String REDIS_KEY = "ADMIN_REDIS_KEY_";

    /**
     * redis 超时时间
     */
    public final static Long REDIS_TIME_OUT = 60 * 60 * 1000L;
}
