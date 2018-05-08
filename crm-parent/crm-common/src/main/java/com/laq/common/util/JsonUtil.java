package com.laq.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;

/**
 * json 工具
 *
 * @author Mr.YongGan.Zhang
 * @version 1.0.0
 */
public final class JsonUtil {

    // 日志
    private static final Logger LOGGER = Logger.getLogger(JsonUtil.class);

    // 将Json数据解析成相应的映射对象
    public static <T> T parseJsonWithGson(String jsonData, Class<T> type) {

        T t = JSON.parseObject(jsonData, type);
        return t;
    }

    /**
     * 将对象转成为 json
     *
     * @param t
     * @return
     */
    public static <T> String parseObjectToString(final T t) {

        String jsonString = JSON.toJSONString(t);
        return jsonString;
    }

    /**
     * @param response
     * @param date
     */
    public static void write(HttpServletResponse response, String json) {

        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            LOGGER.error("json 写出 异常", e);
        }
        out.write(json);
        out.flush();
        out.close();
    }
}