
/**
 * @模块名:oauth2-server
 * @包名:cn.cc.study.config
 * @描述:NoEncryptPasswordEncoder.java
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午4:04:51
 */

package cn.cc.study.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import cn.cc.study.util.DigestUtil;

/**
 * @模块名:oauth2-server
 * @包名:cn.cc.study.config
 * @类名称: NoEncryptPasswordEncoder
 * @类描述:【类描述】自定义加密策略
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月18日下午4:04:51
 */
public class NoEncryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return (String) charSequence;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null || encodedPassword == null) {
            return false;
        }
        else {
            try {
                return encodedPassword.equals(DigestUtil.encrypt((String) rawPassword));
            }
            catch (Exception e) {
                return false;
            }
        }

    }
}