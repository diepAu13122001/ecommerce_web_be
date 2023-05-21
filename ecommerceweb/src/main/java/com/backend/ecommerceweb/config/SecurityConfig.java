package com.backend.ecommerceweb.config;


import com.backend.ecommerceweb.security.AuthenticationFilter;
import com.backend.ecommerceweb.utils.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(tokenAuthenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:8080");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
//        httpSecurity.addFilterBefore(new AuthenticationFilter(authenticationManager(), Constants.HEADER_TOKEN_NAME), UsernamePasswordAuthenticationFilter.class)
//                .csrf()
//                .disable();
//                .and()
//                .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
        httpSecurity
                .cors().configurationSource(source)
                .and()
                .csrf().disable().authorizeRequests().antMatchers(Constants.AUTH_SERVICE_URL+"/register").permitAll()
                .and()
                .csrf().disable()
                .addFilterBefore(
                        new AuthenticationFilter(authenticationManager(), "HEADER_TOKEN_NAME"),
                        BasicAuthenticationFilter.class);
    }



}
