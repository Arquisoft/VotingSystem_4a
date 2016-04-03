package es.uniovi.asw.model;

import javax.persistence.*;

/**
 * Candidate
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Candidate)) return false;

		Candidate candidate = (Candidate) o;

		return getName() != null ? getName().equals(candidate.getName()) : candidate.getName() == null;

	}

	@Override
	public int hashCode() {
		return getName() != null ? getName().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Candidate{" +
				"name='" + name + '\'' +
				", candidatureList=" + candidatureList +
				'}';
	}
}
