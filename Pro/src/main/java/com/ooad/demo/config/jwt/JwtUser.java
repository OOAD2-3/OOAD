package com.ooad.demo.config.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ooad.demo.entity.Role;
import com.ooad.demo.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @Author: 17Wang
 * @Date: 10:00 2018/12/10
 */
public class JwtUser implements UserDetails, Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtUser(User user) {
        this.id = user.getId();
        this.username = user.getAccount();
        this.password = user.getPassword();
        this.email = user.getEmail();

        List<Role> roles = user.getRoles();
        List<String> rolePlayer = new ArrayList<>();

        for (Role role : roles) {
            rolePlayer.add(role.getRoleName());
        }

        this.authorities = rolePlayer.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return false;
    }

    @JsonIgnore
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
