package com.software.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.*;

import javax.management.remote.rmi._RMIConnection_Stub;
import javax.ws.rs.GET;


/**
 * Created with IntelliJ IDEA.
 *
 * @author gaohu9712@163.com
 * @date 2020/10/29
 * @description
 */

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallBack", commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value="true"),                   // 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value="10"),     // 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value="10000"),// 时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60")    // 关效率达到 60% 后熔断
    })
    public Object get(@PathVariable("id") Integer id) {

        if (1 == id) {
            throw new  RuntimeException("id 不能为 1");
        }
        return Thread.currentThread().getName() + " --- 你已经消费了 --- " + id;
    }

    public Object getFallBack(Integer id) {
        return Thread.currentThread().getName() + " --- 服务降级， id = " + id;
    }

}
