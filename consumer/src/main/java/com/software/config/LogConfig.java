package com.software.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 *
 * @author gaohu9712@163.com
 * @date 2020/11/5
 * @description
 */
@Configuration
public class LogConfig {
    @Bean
    Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }
}
