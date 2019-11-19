package cn.cc.study.common.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

/**
 * 
 * @模块名:oauth2-common
 * @包名:cn.cc.study.common.dto
 * @类名称: CurrentUser
 * @类描述:【类描述】用户封装类
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月19日下午1:39:35
 */
@Data
public class CurrentUser {
    private static final long serialVersionUID = 1L;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色列表
     */
    private List < Integer > roleIds;

    /**
     * 用户属性
     */
    private Map < String, Object > params;

    private String password;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户权限
     */
    private Set < Authority > authorities;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public CurrentUser() {
        super();
    }

    @Data
    public static class Authority {
        public String authority;

        Authority() {
            super();
        }
    }
}
