package com.zxkj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.zxkj.dao")//用来寻找持久层接口的位置
public class ZxkjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZxkjApplication.class, args);
    }

}
