package com.swj.service.demo.impl;

import com.swj.api.demo.dto.DemoReqDTO;
import com.swj.api.demo.dto.DemoRespDTO;
import com.swj.api.demo.entity.DemoDO;
import com.swj.api.demo.service.DemoService;
import com.swj.basic.exception.ServiceException;
import com.swj.basic.helper.ObjectHelper;
import com.swj.mustang.SwjDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;


@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    /**
     * 数据源配置内容请参看ZK节点/common下oracle-pmc的值。！！注意：请不要修改/common节点下的任何值。
     * /common节点属于各个应用的公用配置，应用特有的配置请在ZK根目录下建立应用节点，如/usercenter
     */
    private SwjDao swjDao = SwjDao.get("oracle-pmc");

    /**
     * 接口方法上不加throws Exception的声明
     * 业务异常请抛com.swj.basic.exception.ServiceException(String errorCode, String errorMsg)
     * 意外之外的受检异常请try catch之后抛出原异常的信息，并以error级别打印异常堆栈日志。
     */
    @Override
    public Boolean create(DemoReqDTO demoReqDTO) {
        int count = swjDao.queryScalar("demo.selectCount", ObjectHelper.getParameter("USERNAME", demoReqDTO.getUsername()), Integer.class);
        if (count > 0) {
            throw new ServiceException(1, "用户账号[{}]已存在", demoReqDTO.getUsername());
        }

        // 受检异常
        try {
            InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error("获取ip地址出现异常", e);
            throw new ServiceException(2, e.getMessage());
        }

        DemoDO demoDO = ObjectHelper.copy(demoReqDTO, DemoDO.class);
        demoDO.setId(UUID.randomUUID().toString());
        swjDao.insert(demoDO);
        return true;
    }

    @Override
    public DemoRespDTO get(String id) {
        return swjDao.queryEntity(DemoRespDTO.class, "demo.selectByConditions", ObjectHelper.getParameter("USERID", id));
    }

}



