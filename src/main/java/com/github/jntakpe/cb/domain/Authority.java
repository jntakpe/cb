package com.github.jntakpe.cb.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Bean représentant un rôle associable à un ou plusieurs utilisateurs
 *
 * @author jntakpe
 */
@Entity
@Table(name = "authorities")
public class Authority extends GenericDomain<Short> {

    private String name;

    @ManyToMany
    private Set<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }
}
