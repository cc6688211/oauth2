package cn.cc.study.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @模块名:oauth2-server
 * @包名:cn.cc.study.controller
 * @类名称: MemberController
 * @类描述:【类描述】权限认证控制层
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午4:34:55
 */
@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("hello")
    @PreAuthorize("hasAnyAuthority('hello')")
    public String hello() {
        return "hello";
    }

    @GetMapping("query")
    @PreAuthorize("hasAnyAuthority('query')")
    public String query() {
        return "query";
    }

    /**
     * 
     * @方法名:user
     * @方法描述:用于进行权限校验查询
     * @param member
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午4:07:52
     * @修改人:cc
     * @修改时间:2019年11月19日 下午4:07:52
     */
    @GetMapping("/member")
    public Principal user(Principal member) {
        return member;
    }

    @DeleteMapping(value = "/exit")
    public boolean revokeToken(String access_token) {
        return consumerTokenServices.revokeToken(access_token);
    }
}
