package com.jimmy.Util;


import java.util.HashMap;
import java.util.Map;

/**
 * ajax返回时信息封装
 * User: jimmy Date:2016/3/14 ProjectName: springLearn Version: 1.0
 */
public class ResponseUtils {

    /**
     * 返回页面Map，成功默认返回此信息
     *
     * @return Map ，Key为：000000，Value为：亲，操作成功
     */
    public static Map<String, Object> getResponseSuccessMap(final Object obj) {
        return getResponseMap(ConstUtil.SUCCESS_FLAG, obj == null ? "亲，操作成功" : obj);
    }

    /**
     * 返回页面Map，成功默认返回此信息
     *
     * @return Map ，Key为：000000，Value为：亲，操作成功
     */
    public static Map<String, Object> getResponseSuccessMap() {
        return getResponseSuccessMap(null);
    }

    /**
     * 系统异常，返回前端信息，默认返回：亲，系统异常，请稍后重试
     *
     * @return 返回Map，用于Ajax返回的时候封装
     */
    public static Map<String, Object> getResponseFailMap(final Object obj) {
        return getResponseMap(ConstUtil.FAILED_FLAG, obj);
    }

    public static Map<String, Object> getResponseMap(final String key, final Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(ConstUtil.ERROR_CODE, key == null ? ConstUtil.FAILED_FLAG : key);
        map.put(ConstUtil.ERROR_MSG, obj == null ? ConstUtil.SYSTEM_ERROR_MSG : obj);
        return map;
    }

    /**
     * 系统异常，返回前端信息，默认返回：亲，系统异常，请稍后重试
     *
     * @return 返回Map，用于Ajax返回的时候封装
     */
    public static Map<String, Object> getResponseFailMap() {
        return getResponseFailMap(null);
    }

    /**
     * 实例化Map
     *
     * @param map 需要在此Map中追加信息
     * @param key 需要保存到Map中的Key
     * @param obj 需要保存到的Map的Value
     * @return 返回Map，用于Ajax返回的时候封装
     */
    public static Map<String, Object> getResponseMap(final Map<String, Object> map, final String key,
                                                     final Object obj) {
        if (map == null) {
            Map<String, Object> newMap = new HashMap<String, Object>();
            newMap.put(key, obj);
            return newMap;
        }
        map.put(key, obj);
        return map;
    }

    /**
     * 封装捕获异常时返回的信息
     *
     * @param e 异常信息
     * @return 返回Map，用于Ajax返回的时候封装
     */
    public static Map<String, Object> getResponseMap(Exception e) {
        return getResponseFailMap(getResponseString(e));
    }


    /**
     * 返回异常信息
     *
     * @param e 错误异常
     * @return 异常描述
     */
    public static String getResponseString(Exception e) {

        return e.getStackTrace().toString();
    }
}
