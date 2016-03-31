package es.uniovi.asw.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 29/03/16.
 */
@Entity
@DiscriminatorValue("CandidatureList")
public class CandidatureList extends Candidature {

	private static final long serialVersionUID = -1130784911884346604L;

	@Column(nullable = false)
	private String listName;

	@OneToMany(mappedBy = "candidatureList", cascade = {CascadeType.ALL })
	private Set<Candidate> candidates = new HashSet<Candidate>();

	public CandidatureList() {}

	public CandidatureList(String listName) {
		this.listName = listName;
	}

	public void addCandidate(Candidate candidate) {
		if (candidates.add(candidate)) {
			candidate.setCandidatureList(this);
		}
	}

	public void removeCandidate(Candidate candidate) {
		if (candidates.remove(candidate)) {
			candidate.setCandidatureList(null);
		}
	}

	public Set<Candidate> getCandidates() {
		return candidates;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}
}
