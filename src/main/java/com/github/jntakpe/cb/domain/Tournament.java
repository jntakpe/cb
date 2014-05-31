package com.github.jntakpe.cb.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Bean représentant un tournoi
 *
 * @author jntakpe
 */
@Entity
public class Tournament extends GenericDomain<Short> {

    private String name;

    @OneToMany(mappedBy = "tournament")
    private Set<Team> teams;

    @OneToMany(mappedBy = "tournament")
    private Set<Group> groups;


}
