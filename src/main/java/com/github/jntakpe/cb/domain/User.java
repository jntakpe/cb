package com.github.jntakpe.cb.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Bean représentant un utilisateur de l'application
 *
 * @author jntakpe
 */
@Entity
@Table(name = "users")
public class User extends GenericDomain<Short> {

    private String login;

    private String name;

    @ManyToMany
    private Set<Authority> authorities;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
