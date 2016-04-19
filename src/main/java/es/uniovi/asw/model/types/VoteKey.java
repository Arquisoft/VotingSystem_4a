package es.uniovi.asw.model.types;

import java.io.Serializable;

/**
 * VoteKey
 * Created by ivan on 19/04/16.
 */
public class VoteKey implements Serializable {

	private static final long serialVersionUID = 3104753027215144449L;

	Long candidature;
	Long votingPlace;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof VoteKey)) return false;

		VoteKey voteKey = (VoteKey) o;

		return candidature != null ? candidature.equals(voteKey.candidature) : voteKey.candidature == null && (votingPlace != null ? votingPlace.equals(voteKey.votingPlace) : voteKey.votingPlace == null);

	}

	@Override
	public int hashCode() {
		int result = candidature != null ? candidature.hashCode() : 0;
		result = 31 * result + (votingPlace != null ? votingPlace.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "VoteKey{" +
				"candidature=" + candidature +
				", votingPlace=" + votingPlace +
				'}';
	}
}
