package com.software.feign.impl;

import com.software.feign.ProviderFeign;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author gaohu9712@163.com
 * @date 2020/11/6
 * @description
 */
@Component
public class FeignFallBack implements ProviderFeign {
    @Override
    public String get(@PathVariable("id") Integer id) {
        return "服务端不通";
    }
}
