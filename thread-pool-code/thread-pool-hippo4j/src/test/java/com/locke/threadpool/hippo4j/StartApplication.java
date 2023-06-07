package com.locke.threadpool.hippo4j;

import cn.hippo4j.core.enable.EnableDynamicThreadPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author PengLuo22
 * @date 2023/6/7
 * @since 0.0.1
 */
@SpringBootApplication
@EnableDynamicThreadPool
public class StartApplication {

    public static void main(String[] args) {
        SpringApplication.run(StartApplication.class, args);
    }

}
