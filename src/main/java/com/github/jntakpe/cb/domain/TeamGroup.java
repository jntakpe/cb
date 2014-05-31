package com.github.jntakpe.cb.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Correspondance entre un groupe et les équipes qui le composent
 *
 * @author jntakpe
 */
@Entity
public class TeamGroup extends GenericDomain<Integer> {

    @ManyToOne
    private Group group;

    @ManyToOne
    private Team team;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamGroup teamGroup = (TeamGroup) o;

        if (group != null ? !group.equals(teamGroup.group) : teamGroup.group != null) return false;
        return !(team != null ? !team.equals(teamGroup.team) : teamGroup.team != null);

    }

    @Override
    public int hashCode() {
        int result = group != null ? group.hashCode() : 0;
        result = 31 * result + (team != null ? team.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeamGroup{" +
                "group=" + group +
                ", team=" + team +
                '}';
    }
}
