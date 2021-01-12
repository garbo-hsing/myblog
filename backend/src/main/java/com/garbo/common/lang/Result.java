package com.garbo.common.lang;

import com.garbo.utils.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author garbo
 * @description 统一结果封装
 * @create 2021-01-12 8:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result implements Serializable {

    private int code;    // 访问状态:200正常，非200表示异常
    private String msg;     // 返回消息
    private Object data;    // 返回数据

    // 操作成功
    public static String succeed(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return JsonUtils.objectToString(result);
    }

    public static String succeed(Object data) {
        return succeed(200, "操作成功", data);
    }

    // 操作失败
    public static String fail(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return JsonUtils.objectToString(result);
    }

    public static String fail(String msg, Object data) {
        return fail(400, msg, data);
    }

    public static String fail(String msg) {
        return fail(msg, null);
    }
}
