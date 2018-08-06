package com.swj.api.demo.dto;

import com.swj.basic.annotation.Pattern;
import com.swj.basic.annotation.Require;
import com.swj.basic.annotation.Sensitive;
import com.swj.basic.dto.BaseParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(callSuper = true, exclude = "password")
public class DemoReqDTO extends BaseParam {

    @Require
    @Pattern(regexp = "^(?![0-9]+$)[0-9A-Za-z]{4,20}$", errorMessage = "用户账号须由4-20个数字，字母组成")
    private String username;

    private String id;

    private String name;

    /** 日志打印脱敏处理 */
    @Sensitive
    private String password;

    private String description;

}

