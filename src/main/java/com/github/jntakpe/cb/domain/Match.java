package com.github.jntakpe.cb.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

/**
 * Bean représentant un match
 *
 * @author jntakpe
 */
@Entity
public class Match extends GenericDomain<Integer> {

    private Date date;

    @ManyToOne
    private Group group;

    @ManyToOne
    private Bracket bracket;

    @ManyToOne
    private Match nextMatch;

    @OneToMany(mappedBy = "nextMatch")
    private Set<Match> previousMatches;

    @OneToMany(mappedBy = "match")
    private Set<TeamMatch> teamMatches;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bracket getBracket() {
        return bracket;
    }

    public void setBracket(Bracket bracket) {
        this.bracket = bracket;
    }

    public Match getNextMatch() {
        return nextMatch;
    }

    public void setNextMatch(Match nextMatch) {
        this.nextMatch = nextMatch;
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

        Match match = (Match) o;

        if (bracket != null ? !bracket.equals(match.bracket) : match.bracket != null) return false;
        if (date != null ? !date.equals(match.date) : match.date != null) return false;
        if (group != null ? !group.equals(match.group) : match.group != null) return false;
        if (teamMatches != null ? !teamMatches.equals(match.teamMatches) : match.teamMatches != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (bracket != null ? bracket.hashCode() : 0);
        result = 31 * result + (teamMatches != null ? teamMatches.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "teamMatches=" + teamMatches +
                ", bracket=" + bracket +
                ", group=" + group +
                ", date=" + date +
                '}';
    }
}
