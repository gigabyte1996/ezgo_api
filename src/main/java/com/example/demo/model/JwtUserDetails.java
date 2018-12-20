package com.example.demo.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@SuppressWarnings("all")
public class JwtUserDetails implements UserDetails {

    private String username;
    private String token;
    private Integer id;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUserDetails(String username, String token, Integer id, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.token = token;
        this.id = id;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getUserName() {
        return username;
    }

    public String getToken() {
        return token;
    }


    public Integer getId() {
        return id;
    }

}
