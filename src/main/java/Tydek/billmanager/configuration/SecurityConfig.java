package Tydek.billmanager.configuration;

import Tydek.billmanager.services.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String[] pathsAccessPermitAll = {
            PathConstant.H2_CONSOLE,
            PathConstant.SWAGGER_UI,
            PathConstant.OPENAPI,
            PathConstant.USER_LOGIN,
    };

    @Autowired
    private JpaUserDetailsService jpaUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(httpSecurityCsrfConfigurer -> {
                    httpSecurityCsrfConfigurer.disable();
                })
                .headers(httpSecurityHeadersConfigurer -> {
                    httpSecurityHeadersConfigurer.frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin());
                })
                .userDetailsService(jpaUserDetailsService)
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry -> {
                    for(String path : this.pathsAccessPermitAll) {
                        authorizationManagerRequestMatcherRegistry.requestMatchers(path).permitAll();
                        authorizationManagerRequestMatcherRegistry.requestMatchers(path+"/**").permitAll();
                    }
                    authorizationManagerRequestMatcherRegistry.requestMatchers(PathConstant.USER).permitAll();
                    authorizationManagerRequestMatcherRegistry.requestMatchers(PathConstant.USER+"/**").authenticated();
                })
                .build();
    }

}
