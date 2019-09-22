package com.fc.common.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class BeanUtils {

    /**
     * 将对象转成Map,属性名为key,属性值为value
     *
     * @param object 对象
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objToMap(Object object) {

        Class clazz = object.getClass();
        Map<String, Object> treeMap = new TreeMap<String, Object>();
        try {
            while (null != clazz.getSuperclass()) {
                Field[] declaredFields1 = clazz.getDeclaredFields();

                for (Field field : declaredFields1) {
                    String name = field.getName();

                    // 获取原来的访问控制权限
                    boolean accessFlag = field.isAccessible();
                    // 修改访问控制权限
                    field.setAccessible(true);
                    Object value = field.get(object);
                    // 恢复访问控制权限
                    field.setAccessible(accessFlag);

                    if (null != value && StringUtils.isNotBlank(value.toString())) {
                        //如果是List,将List转换为json字符串
                        if (value instanceof List) {
                            value = JSON.toJSONString(value);
                        }
                        treeMap.put(name, value);
                    }
                }

                clazz = clazz.getSuperclass();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return treeMap;
    }
}
