package es.uniovi.asw.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * ReferendumOption
 * Created by ivan on 2/04/16.
 */
@Entity
@DiscriminatorValue("ReferendumOption")
public class ReferendumOption extends Candidature {

	private static final long serialVersionUID = -1872697315315973327L;

	@Column(nullable = false)
	private String option;

	public ReferendumOption() {}

	public ReferendumOption(String option) {
		this.option = option;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ReferendumOption)) return false;

		ReferendumOption that = (ReferendumOption) o;

		return getOption() != null ? getOption().equals(that.getOption()) : that.getOption() == null;

	}

	@Override
	public int hashCode() {
		return getOption() != null ? getOption().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "ReferendumOption{" +
				"option='" + option + '\'' +
				'}';
	}
}
