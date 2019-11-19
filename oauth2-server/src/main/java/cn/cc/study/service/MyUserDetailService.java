package cn.cc.study.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.cc.study.pojo.BaseUser;
import cn.cc.study.pojo.Menu;
import cn.cc.study.pojo.Role;
import cn.cc.study.pojo.User;
import cn.cc.study.util.DigestUtil;

/**
 * 
 * @模块名:oauth2-server
 * @包名:cn.cc.study.service
 * @类名称: MyUserDetailService
 * @类描述:【类描述】自定义UserDetailService
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午2:31:11
 */
@Service("userDetailService")
public class MyUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User member = new User();
        member.setAccount("admin");
        try {
            member.setPassword(DigestUtil.encrypt("123456"));
        }
        catch (Exception e) {
            System.out.println("加密错误");
        }
        if (member == null) {
            throw new UsernameNotFoundException(username);
        }
        Set < GrantedAuthority > grantedAuthorities = new HashSet <>();
        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;
        List < Role > roles = new ArrayList <>();
        Role role1 = new Role();
        role1.setId(1);
        role1.setRoleName("admin");
        roles.add(role1);
        List < Integer > roleIds = new ArrayList < Integer >();
        for (Role role : roles) {
            // 角色必须是ROLE_开头，可以在数据库中设置
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
            grantedAuthorities.add(grantedAuthority);
            roleIds.add(role.getId());
            // 获取权限
            List < Menu > menus = new ArrayList <>();
            Menu menu1 = new Menu();
            menu1.setId(1);
            menu1.setCode("hello");
            menus.add(menu1);
            for (Menu menu : menus) {
                GrantedAuthority authority = new SimpleGrantedAuthority(menu.getCode());
                grantedAuthorities.add(authority);
            }
        }
        BaseUser user = new BaseUser(member.getAccount(), member.getPassword(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, grantedAuthorities);
        user.setClientId("test");
        user.setUserId(member.getId());
        user.setRoleIds(roleIds);
        Map < String, Object > params = new HashMap < String, Object >();
        params.put("aa", "aa");
        user.setParams(params);
        return user;

    }
}
