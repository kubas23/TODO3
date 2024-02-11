package com.example.todo.model;

import javax.persistence.*;

import com.example.todo.security.Authority;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.HashSet;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean isAdmin;

    public boolean getIsAdmin(){
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    private Collection<Authority> authorities;

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities != null ? (Collection<Authority>) new HashSet<>(authorities) : null;
    }
}
