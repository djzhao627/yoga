package com.fc.common.utils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.math.NumberUtils;

public class R extends LinkedHashMap<String, Object> implements Map<String, Object> {
    private static final long serialVersionUID = 1L;
    HttpServletRequest request;

    public R() {
        put("code", 0);
        put("msg", "操作成功");
    }

    public R(Map<String, Object> params) {
        this.putAll(params);
    }

    public static R error() {
        return error(1, "操作失败");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public String getString(Object key) {
        String val = null;
        try {
            if (null != get(key)) {
                val = get(key).toString();
            }
        } catch (Exception e) {
            return null;
        }
        return val;
    }

    public Double getDouble(Object key) {
        String val = null;
        if (null != get(key)) {
            val = get(key).toString();
        }

        if (null != val && NumberUtils.isNumber(val)) {
            Double num = Double.parseDouble(val);
            return num;
        }
        return null;
    }

    public Integer getInteger(Object key) {
        String val = null;
        if (null != get(key)) {
            val = get(key).toString();
        }

        if (null != val && NumberUtils.isNumber(val)) {
            return Integer.parseInt(val);
        }
        return null;
    }

    // 转换成指定javabean对象
    public <T> T toBean(Class<T> clazz) throws Exception {
        T result = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            com.fc.common.domain.Field fieldAnnotation = field.getAnnotation(com.fc.common.domain.Field.class);
			/*if (fieldAnnotation == null)
				continue;*/
            String fieldName = field.getName();
            field.setAccessible(true);
            Object val = get(fieldName);
            if (val == null || val == "")
                continue;
            Class fieldType = field.getType();
            if (fieldType.equals(Integer.class)) {
                val = Integer.parseInt(val.toString());
            } else if (fieldType.equals(Double.class)) {
                val = Double.parseDouble(val.toString());
            } else if (fieldType.equals(Float.class)) {
                val = Float.parseFloat(val.toString());
            } else if (fieldType.equals(Long.class)) {
                val = Long.parseLong(val.toString());
            } else if (fieldType.equals(String.class)) {
                val = val.toString();
            } else {

            }
            field.set(result, val);
        }
        return result;
    }
}
