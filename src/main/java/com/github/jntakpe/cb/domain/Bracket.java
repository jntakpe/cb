package com.github.jntakpe.cb.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

/**
 * Bean représentant un arbre de tournoi
 *
 * @author jntakpe
 */
@Entity
public class Bracket extends GenericDomain<Short> {

    private Short teamNumber;

    @ManyToOne
    private Tournament tournament;

    @OneToMany(mappedBy = "bracket")
    private Set<Match> matches;

    public Short getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(Short teamNumber) {
        this.teamNumber = teamNumber;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Set<Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<Match> matches) {
        this.matches = matches;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bracket bracket = (Bracket) o;

        if (tournament != null ? !tournament.equals(bracket.tournament) : bracket.tournament != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return tournament != null ? tournament.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Bracket{" +
                "tournament=" + tournament +
                '}';
    }
}
