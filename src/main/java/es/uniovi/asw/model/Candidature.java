package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 29/03/16.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Candidature implements Serializable {

	private static final long serialVersionUID = 3135434615125216327L;

	@Id
	@GeneratedValue()
	private Long id;

	@ManyToOne
	private District district;

	@OneToMany(mappedBy = "candidature", cascade = { CascadeType.ALL })
	private Set<Vote> votes = new HashSet<Vote>();

	public Candidature() {}

	public void addVote(Vote vote) {
		if (votes.add(vote)) {
			vote.setCandidature(this);
		}
	}

	public void removeVote(Vote vote) {
		if (votes.remove(vote)) {
			vote.setCandidature(null);
		}
	}

	public Set<Vote> getVotes() {
		return votes;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public Long getId() {
		return id;
	}
}
