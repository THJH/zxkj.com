package com.zxkj.config;

import com.zxkj.interceptor.LoginInterceptor;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 在web的配置文件中，实例化登陆的拦截器，并添加规则
 */
//@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/resources/templates/login")
                .excludePathPatterns("/user/showLoginPage")
                .excludePathPatterns("/static/**");
    }

}