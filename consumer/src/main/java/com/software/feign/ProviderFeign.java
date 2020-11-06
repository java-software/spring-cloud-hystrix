package com.software.feign;

import com.software.feign.impl.FeignFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author gaohu9712@163.com
 * @date 2020/11/5
 * @description
 */
@Component
@FeignClient(value = "ProviderServer", fallback = FeignFallBack.class)
public interface ProviderFeign {

    @GetMapping("/provider/get/{id}")
    public String get(@PathVariable("id") Integer id);
}
