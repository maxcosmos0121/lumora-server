package com.lumora;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * 启动程序
 *
 * @author Leo
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class LumoraApplication {
    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(LumoraApplication.class, args);
        System.out.println("===================");
        System.out.println("项目启动成功！");
        System.out.println("===================");
    }
}
