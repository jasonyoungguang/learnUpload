package com.swj.service.demo.enums;

import lombok.Getter;

@Getter
public enum DemoEnum {

    demo1("demo1", "demo1"),
    demo2("demo1", "demo1"),;

    private String code;
    private String desc;

    DemoEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}