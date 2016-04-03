package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Region
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
	private Election election;

	@OneToMany(mappedBy = "region", cascade = { CascadeType.ALL })
	private Set<District> districts = new HashSet<>();

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Region)) return false;

		Region region = (Region) o;

		return getName() != null ? getName().equals(region.getName()) : region.getName() == null;

	}

	@Override
	public int hashCode() {
		return getName() != null ? getName().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "Region{" +
				"id=" + id +
				", name='" + name + '\'' +
				", election=" + election +
				'}';
	}
}
