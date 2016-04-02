package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ElectionCall
 * Created by ivan on 29/03/16.
 */
@Entity
public class ElectionCall implements Serializable {

	private static final long serialVersionUID = 6021333742657085216L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@OneToMany(mappedBy = "electionCall", cascade = { CascadeType.ALL })
	private Set<Election> elections = new HashSet<Election>();

	public ElectionCall() {}

	public ElectionCall(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public void addElection(Election election) {
		if (elections.add(election)) {
			election.setElectionCall(this);
		}
	}

	public void removeElection(Election election) {
		if (elections.remove(election)) {
			election.setElectionCall(null);
		}
	}

	public Set<Election> getElections() {
		return elections;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ElectionCall)) return false;

		ElectionCall that = (ElectionCall) o;

		return getName() != null ? getName().equals(that.getName()) : that.getName() == null && (getDescription() != null ? getDescription().equals(that.getDescription()) : that.getDescription() == null);

	}

	@Override
	public int hashCode() {
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
		return result;
	}
}
