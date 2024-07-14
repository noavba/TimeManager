package com.example.timemanager.security.services;

import com.example.timemanager.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements  UserDetails {

        @Serial
        private static final long serialVersionUID = 1L;

        private Integer id;

        private String username;

        private String email;

        @JsonIgnore
        private String password;

        private final Collection<? extends GrantedAuthority> authorities;

        public UserDetailsImpl(int id, String username, String email, String password,
                               Collection<? extends GrantedAuthority> authorities) {
            this.id = id;
            this.username = username;
            this.email = email;
            this.password = password;
            this.authorities = authorities;
        }

        public static UserDetails build(User user) {
            List<GrantedAuthority> authorities = user.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                    .collect(Collectors.toList());

            return new UserDetailsImpl(
                    user.getId(),
                    user.getUsername(),
                    user.getEmail(),
                    user.getPassword(),
                    authorities);
        }

        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        public Integer getId(){
            return id;
        }
        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
        }



        public boolean isAccountNonExpired() {
            return true;
        }

        public boolean isAccountNonLocked() {
            return true;
        }

        public boolean isCredentialsNonExpired() {
            return true;
        }

        public boolean isEnabled() {
            return true;
        }
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            UserDetailsImpl user = (UserDetailsImpl) o;
            return Objects.equals(id, user.id);
        }



}
