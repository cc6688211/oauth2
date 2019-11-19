package cn.cc.study.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @模块名:oauth2-client
 * @包名:cn.cc.study.config
 * @类名称: ResourceServerConfig
 * @类描述:【类描述】资源认证配置类,注意antMatchers的路径配置
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月19日上午9:05:52
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and().requestMatchers().antMatchers("/api/**").and().authorizeRequests().antMatchers("/api/**")
                .authenticated().and().httpBasic();
    }
}
