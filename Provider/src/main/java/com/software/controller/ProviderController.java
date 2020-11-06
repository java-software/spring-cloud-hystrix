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
    public Object get(@PathVariable("id") Integer id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + " --- 你已经消费了 --- " + id;
    }

}
