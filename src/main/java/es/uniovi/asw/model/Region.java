package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ivan on 29/03/16.
 */
@Entity
public class Region implements Serializable {

	private static final long serialVersionUID = 3236185159797200635L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "id")
	private Election election;

	@OneToMany(mappedBy = "region", cascade = { CascadeType.ALL })
	private Set<District> districts = new HashSet<District>();

	public Region() {}

	public Region(String name) {
		this.name = name;
	}

	public void addDistrict(District district) {
		if (districts.add(district)) {
			district.setRegion(this);
		}
	}

	public void removeDistrict(District district) {
		if (districts.remove(district)) {
			district.setRegion(null);
		}
	}

	public Set<District> getDistricts() {
		return districts;
	}

	public Election getElection() {
		return election;
	}

	public void setElection(Election election) {
		this.election = election;
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
