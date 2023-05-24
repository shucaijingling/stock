package com.shucai.bulls.stock.cat.demo.gateway.catutils;

import com.dianping.cat.Cat;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class CatContext implements Cat.Context{
    /**
     * 存储监控相关信息
     */
    private Map<String, String> properties = new HashMap<>();

    @Override
    public void addProperty(String key, String value) {
        properties.put(key, value);
    }

    @Override
    public String getProperty(String s) {
        return properties.get(s);
    }
}
