package net.noosters.csce747.homework4;

public class Time {
	
	private int day;
	private int timeOfDay;

	public Time(int day, int hour, int minute) {
		if (day < 0 || day > 6) {
			throw new IllegalArgumentException("Day must be between 0 and 6 inclusive.");
		}
		this.day = day;
		this.timeOfDay = (hour * 60) + minute;

		if (timeOfDay < 0 || timeOfDay > 1440) {
			throw new IllegalArgumentException("Time of day must compute to be between 0 and 1439 inclusive.");
		}
	}
	
	/**
	 * 0 = Sunday, 1 = Monday, 2 = Tuesday, 3 = Wednesday, 4 = Thursday, 5 = Friday, 6 = Saturday
	 * @return which day of the week this Time represents
	 */
	public int getDay() {
		return day;
	}

	/**
	 * between 0 and 1440
	 * @return the number of minutes into the day where 0 is midnight and 1439 is 11:59 PM
	 */
	public int getTimeOfDay() {
		return timeOfDay;
	}

}
