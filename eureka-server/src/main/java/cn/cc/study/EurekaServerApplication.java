
/**
 * @模块名：eureka-server
 * @包名：cn.cc.study
 * @描述：EurekaServerApplication.java
 * @版本：1.0
 * @创建人：cc
 * @创建时间：2019年11月18日上午10:35:07
 */

package cn.cc.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @模块名:eureka-server
 * @包名:cn.cc.study
 * @类名称: EurekaServerApplication
 * @类描述:【类描述】
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日上午10:38:56
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}