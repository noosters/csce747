package net.noosters.csce747.homework4;

import org.junit.Assert;
import org.junit.Test;

public class TimeTest {

	@Test(expected=IllegalArgumentException.class)
	public void testDayLowerBound() {
		new Time(-1, 0, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testDayUpperBound() {
		new Time(7, 0, 0);
	}

	@Test
	public void testValidTime() {
		Time time = new Time(0, 7, 45);
		Time time2 = new Time(6, 10, 30);
		Assert.assertEquals(0, time.getDay());
		Assert.assertEquals(465, time.getTimeOfDay());
		Assert.assertEquals(6, time2.getDay());
		Assert.assertEquals(630, time2.getTimeOfDay());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMinuteLowerBound() {
		new Time(0, 0, -1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testMinuteUpperBound() {
		new Time(0, 0, 1441);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHourLowerBound() {
		new Time(0, -1, 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testHourUpperBound() {
		new Time(0, 25, 0);
	}
}
