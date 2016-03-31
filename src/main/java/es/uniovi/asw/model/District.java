package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 29/03/16.
 */
@Entity
public class District implements Serializable {

	private static final long serialVersionUID = -2075450364764273079L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "id")
	private Region region;

	@OneToMany(mappedBy = "district", cascade = { CascadeType.ALL })
	private Set<VotingPlace> votingPlaces = new HashSet<>();

	@OneToMany(mappedBy = "district", cascade = { CascadeType.ALL })
	private Set<Candidature> candidatures = new HashSet<Candidature>();

	public District() {}

	public District(String name) {
		this.name = name;
	}

	public void addVotingPlace(VotingPlace votingPlace) {
		if (votingPlaces.add(votingPlace)) {
			votingPlace.setDistrict(this);
		}
	}

	public void removeVotingPlace(VotingPlace votingPlace) {
		if (votingPlaces.remove(votingPlace)) {
			votingPlace.setDistrict(null);
		}
	}

	public Set<VotingPlace> getVotingPlaces() {
		return votingPlaces;
	}

	public void addCandidature(Candidature candidature) {
		if (candidatures.add(candidature)) {
			candidature.setDistrict(this);
		}
	}

	public void removeCandidature(Candidature candidature) {
		if (candidatures.add(candidature)) {
			candidature.setDistrict(null);
		}
	}

	public Set<Candidature> getCandidatures() {
		return candidatures;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
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
