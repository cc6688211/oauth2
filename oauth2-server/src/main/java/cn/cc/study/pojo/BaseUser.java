package cn.cc.study.pojo;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Data;

/**
 * 
 * @模块名:oauth2-server
 * @包名:cn.cc.study.pojo
 * @类名称: BaseUser
 * @类描述:【类描述】基础用户封装类
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午2:50:56
 */
@Data
public class BaseUser extends User {

    public BaseUser(String username, String password, Collection < ? extends GrantedAuthority > authorities) {
        super(username, password, authorities);
    }

    public BaseUser(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection < ? extends GrantedAuthority > authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public BaseUser(String username, String password, Collection < ? extends GrantedAuthority > authorities,
            String clientId, Integer userId, List < Integer > roleIds, Map < String, Object > params) {
        super(username, password, authorities);
        this.clientId = clientId;
        this.userId = userId;
        this.roleIds = roleIds;
        this.params = params;
    }

    public BaseUser(String username, String password, boolean enabled, boolean accountNonExpired,
            boolean credentialsNonExpired, boolean accountNonLocked,
            Collection < ? extends GrantedAuthority > authorities, String clientId, Integer userId,
            List < Integer > roleIds, Map < String, Object > params) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.clientId = clientId;
        this.userId = userId;
        this.roleIds = roleIds;
        this.params = params;
    }

    private static final long serialVersionUID = 1L;

    /**
     * 客户端id
     */
    private String clientId;

    /**
     * 用户id
     */
    private Integer userId;

    private List < Integer > roleIds;

    private Map < String, Object > params;
}
