package cn.cc.study.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @模块名:oauth2-gateway
 * @包名:cn.cc.study.config
 * @类名称: SecurityConfig
 * @类描述:【类描述】Security配置
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午4:40:15
 */
@Configuration
@EnableWebSecurity
@Order(99)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}
