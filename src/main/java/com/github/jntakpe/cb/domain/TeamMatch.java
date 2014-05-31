package com.github.jntakpe.cb.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * Correspondance entre un match et les équipes du match
 *
 * @author jntakpe
 */
@Entity
public class TeamMatch {

    @ManyToOne
    private Team team;

    @ManyToOne
    private Match match;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamMatch teamMatch = (TeamMatch) o;

        if (match != null ? !match.equals(teamMatch.match) : teamMatch.match != null) return false;
        return !(team != null ? !team.equals(teamMatch.team) : teamMatch.team != null);

    }

    @Override
    public int hashCode() {
        int result = team != null ? team.hashCode() : 0;
        result = 31 * result + (match != null ? match.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeamMatch{" +
                "team=" + team +
                ", match=" + match +
                '}';
    }
}
