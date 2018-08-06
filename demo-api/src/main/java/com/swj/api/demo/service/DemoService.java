package com.swj.api.demo.service;

import com.swj.api.demo.dto.DemoReqDTO;
import com.swj.api.demo.dto.DemoRespDTO;
import com.swj.basic.annotation.FreewayPath;
import com.swj.basic.annotation.Require;

@FreewayPath
public interface DemoService {

    DemoRespDTO get(@Require String id);

    Boolean create(DemoReqDTO demoReqDTO);

}
