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

    @OneToMany(mappedBy = "match")
    private Set<TeamMatch> teamMatches;


}
