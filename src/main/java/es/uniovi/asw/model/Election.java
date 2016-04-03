package es.uniovi.asw.model;

import es.uniovi.asw.model.types.ElectionDateTime;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Election
 * Created by ivan on 29/03/16.
 */
@Entity
public class Election implements Serializable {

	private static final long serialVersionUID = -3090872460912223864L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private ElectionDateTime electionDateTime;

	@ManyToOne
	private ElectionCall electionCall;

	@OneToMany(mappedBy = "election", cascade = { CascadeType.ALL })
	private Set<Region> regions = new HashSet<>();

	public Election() {}

	public Election(String description, String name) {
		this.description = description;
		this.name = name;
	}

	public void addRegion(Region region) {
		if (regions.add(region)) {
			region.setElection(this);
		}
	}

	public void removeRegion(Region region) {
		if (regions.remove(region)) {
			region.setElection(null);
		}
	}

	public Set<Region> getRegions() {
		return regions;
	}

	public ElectionCall getElectionCall() {
		return electionCall;
	}

	public void setElectionCall(ElectionCall electionCall) {
		this.electionCall = electionCall;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ElectionDateTime getElectionDateTime() {
		return electionDateTime;
	}

	public void setElectionDateTime(ElectionDateTime electionDateTime) {
		this.electionDateTime = electionDateTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Election)) return false;

		Election election = (Election) o;

		return getName() != null ? getName().equals(election.getName()) : election.getName() == null && (getDescription() != null ? getDescription().equals(election.getDescription()) : election.getDescription() == null && (getElectionDateTime() != null ? getElectionDateTime().equals(election.getElectionDateTime()) : election.getElectionDateTime() == null));

	}

	@Override
	public int hashCode() {
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
		result = 31 * result + (getElectionDateTime() != null ? getElectionDateTime().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Election{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", electionDateTime=" + electionDateTime +
				", electionCall=" + electionCall +
				'}';
	}
}
