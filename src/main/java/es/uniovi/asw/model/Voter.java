package es.uniovi.asw.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ivan on 29/03/16.
 */
@Entity
public class Voter implements Serializable {

	private static final long serialVersionUID = -2570727675899821819L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String nif;

	@Column(nullable = false)
	private Long code;

	@Column(nullable = true)
	private String password;

	@ManyToOne
	private VotingPlace votingPlace;

	public Voter() {}

	public Voter(String name, String email, String nif, Long code, String password)
	{
		this.name = name;
		this.nif = nif;
		this.code = code;
		this.email = email;
		this.password = password;
	}

	public VotingPlace getVotingPlace() {
		return votingPlace;
	}

	public void setVotingPlace(VotingPlace votingPlace) {
		this.votingPlace = votingPlace;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
