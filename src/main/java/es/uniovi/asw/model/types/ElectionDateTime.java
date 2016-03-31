package es.uniovi.asw.model.types;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by ivan on 31/03/16.
 */
@Embeddable
public class ElectionDateTime {

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private Time startTime;

	@Column(nullable = false)
	private Time endTime;

	public ElectionDateTime() {}

	public ElectionDateTime(Date date, Time startTime, Time endTime) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

		if (!getDate().equals(that.getDate())) return false;
		if (!getStartTime().equals(that.getStartTime())) return false;
		return getEndTime().equals(that.getEndTime());
	}

	@Override
	public int hashCode() {
		int result = getDate().hashCode();
		result = 31 * result + getStartTime().hashCode();
		result = 31 * result + getEndTime().hashCode();
		return result;
	}
}
