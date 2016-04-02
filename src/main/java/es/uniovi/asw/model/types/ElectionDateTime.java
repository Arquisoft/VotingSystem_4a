package es.uniovi.asw.model.types;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Time;

/**
 * ElectionDateTime
 * Created by ivan on 31/03/16.
 */
@Embeddable
public class ElectionDateTime {

	@Column(nullable = false)
	private Time startTime;

	@Column(nullable = false)
	private Time endTime;

	public ElectionDateTime() {}

	public ElectionDateTime(Time startTime, Time endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ElectionDateTime)) return false;

		ElectionDateTime that = (ElectionDateTime) o;

		return getStartTime() != null ? getStartTime().equals(that.getStartTime()) : that.getStartTime() == null && (getEndTime() != null ? getEndTime().equals(that.getEndTime()) : that.getEndTime() == null);

	}

	@Override
	public int hashCode() {
		int result = getStartTime() != null ? getStartTime().hashCode() : 0;
		result = 31 * result + (getEndTime() != null ? getEndTime().hashCode() : 0);
		return result;
	}
}
