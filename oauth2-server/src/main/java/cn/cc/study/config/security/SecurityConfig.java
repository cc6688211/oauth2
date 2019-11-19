
/**
 * @模块名:oauth2-server
 * @包名:cn.cc.study.config
 * @描述:SecurityConfig.java
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午4:11:12
 */

package cn.cc.study.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import cn.cc.study.service.MyUserDetailService;

/**
 * @模块名:oauth2-server
 * @包名:cn.cc.study.config
 * @类名称: SecurityConfig
 * @类描述:【类描述】Security配置
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午4:11:12
 */

@Configuration
@EnableWebSecurity
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new NoEncryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers().antMatchers("/oauth/**").and().authorizeRequests().antMatchers("/oauth/**")
                .authenticated().and().csrf().disable();
    }

    /**
     * 实现认证策略
     * 
     * (non-Javadoc)
     * 
     * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    /**
     * 不定义没有password grant_type,密码模式需要AuthenticationManager支持
     *
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
