
/**
 * @模块名:oauth2-server
 * @包名:cn.cc.study.config
 * @描述:ResourceServerConfig.java
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午4:10:31
 */

package cn.cc.study.config.oauth2;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @模块名:oauth2-server
 * @包名:cn.cc.study.config
 * @类名称: ResourceServerConfig
 * @类描述:【类描述】定义资源管理配置，注意antMatchers的路径
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午4:10:31
 */

@Configuration
@EnableResourceServer
@Order(3)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    TokenStore tokenStore;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and().requestMatchers().antMatchers("/api/**").and().authorizeRequests().antMatchers("/api/**")
                .authenticated().and().httpBasic();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }
}
