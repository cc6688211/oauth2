package cn.cc.study.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cc.study.common.dto.CurrentUser;
import cn.cc.study.common.util.SecurityUtil;

/**
 * @模块名:oauth2-client
 * @包名:cn.cc.study.controller
 * @类名称: TestController
 * @类描述:【类描述】
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月19日上午9:11:16
 */
@RestController
@RequestMapping("/api")
public class TestController {
    /**
     * 
     * @方法名:hello
     * @方法描述:用于测试拥有hello的权限
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:48:06
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:48:06
     */
    @GetMapping("hello")
    @PreAuthorize("hasAnyAuthority('hello')")
    public String hello() {
        return "hello";
    }

    /**
     * 
     * @方法名:query
     * @方法描述:用户测试未含有query的权限
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:50:13
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:50:13
     */
    @GetMapping("query")
    @PreAuthorize("hasAnyAuthority('query')")
    public String query() {
        return "具有query权限";
    }

    /**
     * 
     * @方法名:test
     * @方法描述:未加权限则登录即可访问
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:48:44
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:48:44
     */
    @GetMapping("test")
    public String test() {
        return "test";
    }

    /**
     * 
     * @方法名:current
     * @方法描述:获取用户的方式1
     * @param principal
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:49:23
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:49:23
     */
    @GetMapping("current")
    public Principal current(Principal principal) {
        return principal;
    }

    /**
     * 
     * @方法名:current1
     * @方法描述:获取用户的方式2
     * @param authentication
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:49:54
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:49:54
     */
    @GetMapping("current1")
    public Authentication current1(Authentication authentication) {
        return authentication;
    }

    /**
     * 
     * @方法名:current2
     * @方法描述:获取用户的方式3
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:50:02
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:50:02
     */
    @GetMapping("current2")
    public CurrentUser current2() {
        return SecurityUtil.currentUser();
    }

}
