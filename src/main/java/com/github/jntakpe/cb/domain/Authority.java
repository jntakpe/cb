package com.github.jntakpe.cb.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

/**
 * Bean représentant un rôle associable à un ou plusieurs utilisateurs
 *
 * @author jntakpe
 */
@Entity
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authority authority = (Authority) o;

        return !(name != null ? !name.equals(authority.name) : authority.name != null);

    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "name='" + name + '\'' +
                '}';
    }
}
