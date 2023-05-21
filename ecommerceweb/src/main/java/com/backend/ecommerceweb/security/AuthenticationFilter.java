package com.backend.ecommerceweb.security;

import com.google.gson.JsonObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class AuthenticationFilter extends GenericFilterBean {


    private final String HTTP_REQUEST_HEADER_NAME;
    private final AuthenticationManager authenticationManager;


    public AuthenticationFilter(AuthenticationManager authenticationManager, String requestHeaderName) {
        this.authenticationManager = authenticationManager;
        this.HTTP_REQUEST_HEADER_NAME = requestHeaderName;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        System.out.println("[Request] " + httpRequest.getRemoteAddr() + " - " + httpRequest.getMethod() + " - " + httpRequest.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);


    }

    private void processTokenAuthentication(String token) {
        PreAuthenticatedAuthenticationToken requestAuthentication = new PreAuthenticatedAuthenticationToken(token, null);
        Authentication responseAuthentication = authenticationManager.authenticate(requestAuthentication);
        if (responseAuthentication == null || !responseAuthentication.isAuthenticated()) {
            throw new InternalAuthenticationServiceException("Unable to authenticate Domain User for provided credentials");
        }
        SecurityContextHolder.getContext().setAuthentication(responseAuthentication);
    }


//    @Override
//    public void doFilter(jakarta.servlet.ServletRequest servletRequest, jakarta.servlet.ServletResponse servletResponse, jakarta.servlet.FilterChain filterChain) throws IOException, jakarta.servlet.ServletException {
//
//    }
}
