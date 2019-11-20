
/**
 * @模块名:oauth2-common
 * @包名:cn.cc.study.common.config
 * @描述:JwtConfig.java
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月20日上午10:00:35
 */

package cn.cc.study.common.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

/**
 * @模块名:oauth2-common
 * @包名:cn.cc.study.common.config
 * @类名称: JwtConfig
 * @类描述:【类描述】JWT转换器配置
 * @版本:1.0
 * @创建人:cc
 * @创建时间:2019年11月20日上午10:00:35
 */
@Configuration
public class JwtConfig {
    @Autowired
    JwtAccessTokenConverter jwtAccessTokenConverter;

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter);
    }

    @Bean
    protected JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        Resource resource = new ClassPathResource("public.cert"); // 公钥

        String publicKey;
        try {
            publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        converter.setVerifierKey(publicKey);

        return converter;
    }
}
