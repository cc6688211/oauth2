package cn.cc.study.common.util;

import java.util.List;
import java.util.Set;

import org.springframework.security.core.context.SecurityContextHolder;

import com.alibaba.fastjson.JSON;

import cn.cc.study.common.dto.CurrentUser;
import cn.cc.study.common.dto.CurrentUser.Authority;

/**
 * 
 * @模块名:oauth2-common
 * @包名:cn.cc.study.common.util
 * @类名称: SecurityUtil
 * @类描述:【类描述】
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月19日下午1:40:38
 */
public class SecurityUtil {

    /**
     * 
     * @方法名:currentUser
     * @方法描述:用于获得当前用户信息
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:52:00
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:52:00
     */
    public static CurrentUser currentUser() {
        CurrentUser currentUser = JSON.parseObject(JSON
                .parseObject(JSON.toJSONString(SecurityContextHolder.getContext().getAuthentication()))
                .getJSONObject("userAuthentication").getJSONObject("details").getJSONObject("principal").toJSONString(),
                CurrentUser.class);
        return currentUser;
    }

    /**
     * 
     * @方法名:getRoleIds
     * @方法描述:用于获得当前用户的角色id
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:52:28
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:52:28
     */
    public static List < Integer > getRoleIds() {
        return currentUser().getRoleIds();
    }

    /**
     * 
     * @方法名:getGrantedAuthoritys
     * @方法描述:用于获得当前权限列表
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:52:53
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:52:53
     */
    public static Set < Authority > getGrantedAuthoritys() {
        return currentUser().getAuthorities();
    }

    /**
     * 
     * @方法名:isGrantedAuthority
     * @方法描述:是否含有该权限
     * @param menu
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:53:20
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:53:20
     */
    public static boolean isGrantedAuthority(String menu) {
        return currentUser().getAuthorities().contains(menu);
    }

    /**
     * 
     * @方法名:getParam
     * @方法描述:用于获得当前用户属性
     * @param key
     * @return
     * @修改描述:
     * @版本:1.0
     * @创建人:cc
     * @创建时间:2019年11月19日 下午1:53:42
     * @修改人:cc
     * @修改时间:2019年11月19日 下午1:53:42
     */
    public static Object getParam(String key) {
        return currentUser().getParams().get(key);
    }
}
