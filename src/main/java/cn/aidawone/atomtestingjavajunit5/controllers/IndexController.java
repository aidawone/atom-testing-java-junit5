package cn.aidawone.atomtestingjavajunit5.controllers;

import cn.aidawone.atomtestingjavajunit5.exception.ValueNotSupportedException;

public class IndexController {

    public String index() {

        return "index";
    }

    public String oupsHandler() {
        throw new ValueNotSupportedException();
    }
}
