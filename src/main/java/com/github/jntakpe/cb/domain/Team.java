package com.github.jntakpe.cb.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Bean représentant une équipe
 *
 * @author jntakpe
 */
@Entity
public class Team extends GenericDomain<Short> {

    private String name;

    @ManyToOne
    private Sport sport;

    @OneToMany(mappedBy = "team")
    private Set<Tournament> tournaments;

    @OneToMany(mappedBy = "team")
    private Set<TeamGroup> teamGroups;

    @OneToMany(mappedBy = "team")
    private Set<TeamMatch> teamMatches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public Set<TeamGroup> getTeamGroups() {
        return teamGroups;
    }

    public void setTeamGroups(Set<TeamGroup> teamGroups) {
        this.teamGroups = teamGroups;
    }

    public Set<TeamMatch> getTeamMatches() {
        return teamMatches;
    }

    public void setTeamMatches(Set<TeamMatch> teamMatches) {
        this.teamMatches = teamMatches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (name != null ? !name.equals(team.name) : team.name != null) return false;
        return !(sport != null ? !sport.equals(team.sport) : team.sport != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sport != null ? sport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }
}
