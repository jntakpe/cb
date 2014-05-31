package com.github.jntakpe.cb.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Bean représentant une poule
 *
 * @author jntakpe
 */
@Entity
public class Group extends GenericDomain<Short> {

    private String name;

    @ManyToOne
    private Tournament tournament;

    @OneToMany(mappedBy = "group")
    private Set<TeamGroup> teamGroups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Set<TeamGroup> getTeamGroups() {
        return teamGroups;
    }

    public void setTeamGroups(Set<TeamGroup> teamGroups) {
        this.teamGroups = teamGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        return !(tournament != null ? !tournament.equals(group.tournament) : group.tournament != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (tournament != null ? tournament.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}
