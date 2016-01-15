package net.meshkorea.sample.contacts.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * Created by jihunlee on 2016. 1. 14..
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("curl")
                    .authorities("ROLE_ADMIN")
                    .scopes("read", "write")
                    .authorizedGrantTypes("client_credentials", "password", "implicit", "authorization_code", "refresh_token")
                    .secret("password")
                .and()
                .withClient("web")
                    .redirectUris("http://github.com/techdev-solutions/")
                    .resourceIds("jaxenter")
                    .scopes("read")
                    .authorizedGrantTypes("implicit")
                .and()
                .withClient("postman")
                    .authorities("ROLE_POSTMAN")
                    .scopes("read", "write")
                    .authorizedGrantTypes("client_credentials", "implicit", "authorization_code", "refresh_token")
                    .secret("postman")
                    .redirectUris("https://www.getpostman.com/oauth2/callback")

        ;
    }

}
