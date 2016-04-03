package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Vote
 * Created by ivan on 29/03/16.
 */
@Entity
public class Vote implements Serializable {

	private static final long serialVersionUID = -5096934069175328173L;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	private VotingPlace votingPlace;

	@ManyToOne
	private Candidature candidature;

	public Vote() {}

	public VotingPlace getVotingPlace() {
		return votingPlace;
	}

	public void setVotingPlace(VotingPlace votingPlace) {
		this.votingPlace = votingPlace;
	}

	public Candidature getCandidature() {
		return candidature;
	}

	public void setCandidature(Candidature candidature) {
		this.candidature = candidature;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Vote{" +
				"id=" + id +
				", votingPlace=" + votingPlace +
				", candidature=" + candidature +
				'}';
	}
}
