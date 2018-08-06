package com.swj.api.demo.dto;

import com.swj.basic.annotation.Sensitive;
import com.swj.basic.dto.BaseResult;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, exclude = "password")
public class DemoRespDTO extends BaseResult {

    private String username;

    private String id;

    private String name;

    /** 日志打印脱敏处理 */
    @Sensitive
    private String password;

    private String description;

}

