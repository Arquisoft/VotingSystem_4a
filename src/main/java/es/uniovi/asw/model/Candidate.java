package es.uniovi.asw.model;

import javax.persistence.*;

/**
 * Created by ivan on 29/03/16.
 */
@Entity
@DiscriminatorValue("Candidate")
public class Candidate extends Candidature {

	private static final long serialVersionUID = -2696885021892064778L;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	private CandidatureList candidatureList;

	public Candidate() {}

	public Candidate(String name) {
		this.name = name;
	}

	public CandidatureList getCandidatureList() {
		return candidatureList;
	}

	public void setCandidatureList(CandidatureList candidatureList) {
		this.candidatureList = candidatureList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
