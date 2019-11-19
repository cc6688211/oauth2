package cn.cc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @模块名:oauth2-client
 * @包名:cn.cc.study
 * @类名称: Oauth2ClientApplication
 * @类描述:【类描述】
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月19日上午9:02:35
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class Oauth2ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2ClientApplication.class, args);
    }

}
