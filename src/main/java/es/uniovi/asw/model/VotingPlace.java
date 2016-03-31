package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 29/03/16.
 */
@Entity
public class VotingPlace implements Serializable {

	private static final long serialVersionUID = -3874085987261119609L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	private District district;

	@OneToMany(mappedBy = "votingPlace", cascade = { CascadeType.ALL })
	private Set<Voter> voters = new HashSet<Voter>();

	@OneToMany(mappedBy = "votingPlace", cascade = { CascadeType.ALL })
	private Set<Vote> votes = new HashSet<Vote>();

	public VotingPlace() {}

	public VotingPlace(String name) {
		this.name = name;
	}

	public void addVoter(Voter voter) {
		if (voters.add(voter)) {
			voter.setVotingPlace(this);
		}
	}

	public void removeVoter(Voter voter) {
		if (voters.remove(voter)) {
			voter.setVotingPlace(null);
		}
	}

	public Set<Voter> getVoters() {
		return voters;
	}

	public void addVote(Vote vote) {
		if (votes.add(vote)) {
			vote.setVotingPlace(this);
		}
	}

	public void removeVote(Vote vote) {
		if (votes.remove(vote)) {
			vote.setVotingPlace(null);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
