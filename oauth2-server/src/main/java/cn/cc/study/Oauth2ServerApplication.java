
/**
 * @模块名:oauth2-server
 * @包名:cn.cc.study
 * @描述:Oauth2ServerApplication.java
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日上午11:03:35
 */

package cn.cc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @模块名:oauth2-server
 * @包名:cn.cc.study
 * @类名称: Oauth2ServerApplication
 * @类描述:【类描述】
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日上午11:03:35
 */
@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
public class Oauth2ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(Oauth2ServerApplication.class, args);
    }
}
