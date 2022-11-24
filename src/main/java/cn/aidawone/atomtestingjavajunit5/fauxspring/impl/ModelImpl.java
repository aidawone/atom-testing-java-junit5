package cn.aidawone.atomtestingjavajunit5.fauxspring.impl;

import cn.aidawone.atomtestingjavajunit5.fauxspring.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author：zhanggr
 * @date: 2022/11/23
 */
public class ModelImpl implements Model {
    public Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        //map.put(key, o);
    }
}
