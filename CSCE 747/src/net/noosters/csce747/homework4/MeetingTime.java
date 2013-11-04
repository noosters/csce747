package net.noosters.csce747.homework4;

public class MeetingTime extends Time {
	//start time is held by the parent
	private Time endTime;
	
	public MeetingTime(int startDay, int startHour, int startMinute,
			int endDay, int endHour, int endMinute) {
		super(startDay, startHour, startMinute);
		endTime = new Time(endDay, endHour, endMinute);

		if (getTimeOfWeek(this) >= getTimeOfWeek(endTime)) {
			throw new IllegalArgumentException("Start time must be before end time.");
		}
	}

	public boolean overlap(MeetingTime other) {
		if (getTimeOfWeek(this) >= getTimeOfWeek(other)
				&& getTimeOfWeek(this) <= getTimeOfWeek(other.endTime)) {
			//this start is between the other start and end
			return true;
		} else if (getTimeOfWeek(endTime) >= getTimeOfWeek(other)
				&& getTimeOfWeek(endTime) <= getTimeOfWeek(other.endTime)) {
			//this end is between the other start and end
			return true;
		} else if (getTimeOfWeek(this) >= getTimeOfWeek(other)
				&& getTimeOfWeek(endTime) <= getTimeOfWeek(other.endTime)
				||
				getTimeOfWeek(other) >= getTimeOfWeek(this)
				&& getTimeOfWeek(other.endTime) <= getTimeOfWeek(endTime)) {
			//this start and end is between the other start and end or vice-versa
			return true;
		}
		else {
			//otherwise not overlapping
			return false;
		}
	}

	//helper method to make the overlap logic more readable
	private static int getTimeOfWeek(Time time) {
		return time.getDay() * 1440 + time.getTimeOfDay();
	}
}
