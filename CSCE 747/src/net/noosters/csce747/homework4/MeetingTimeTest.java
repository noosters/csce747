package net.noosters.csce747.homework4;

import junit.framework.Assert;

import org.junit.Test;

public class MeetingTimeTest {

	@Test(expected=IllegalArgumentException.class)
	public void testEndBeforeStart() {
		new MeetingTime(1, 10, 0, 1, 9, 59);
	}

	@Test
	public void testNoOverlap() {
		MeetingTime class1 = new MeetingTime(1, 8, 5, 1, 9, 20);
		MeetingTime class2 = new MeetingTime(1, 10, 5, 1, 11, 20);

		Assert.assertFalse(class1.overlap(class2));
		Assert.assertFalse(class2.overlap(class1)); //either order should be the same
	}

	@Test
	public void testOverlappingEnd() {
		MeetingTime class1 = new MeetingTime(2, 14, 50, 2, 16, 5);
		MeetingTime class2 = new MeetingTime(1, 0, 0, 2, 16, 5);

		Assert.assertTrue(class1.overlap(class2));
		Assert.assertTrue(class2.overlap(class1));
	}

	@Test
	public void testOverlappingStart() {
		MeetingTime class1 = new MeetingTime(5, 10, 40, 5, 11, 30);
		MeetingTime class2 = new MeetingTime(5, 10, 40, 5, 11, 0);

		Assert.assertTrue(class1.overlap(class2));
		Assert.assertTrue(class2.overlap(class1));
	}

	@Test
	public void testOverlapDuring() {
		MeetingTime class1 = new MeetingTime(6, 9, 0, 6, 17, 0);
		MeetingTime class2 = new MeetingTime(6, 14, 30, 6, 16, 0);

		Assert.assertTrue(class1.overlap(class2));
		Assert.assertTrue(class2.overlap(class1));
	}

	@Test
	public void testIdenticalMeetingTime() {
		MeetingTime class1 = new MeetingTime(3, 14, 0, 3, 19, 45);
		MeetingTime class2 = new MeetingTime(3, 14, 0, 3, 19, 45);

		Assert.assertTrue(class1.overlap(class2));
		Assert.assertTrue(class2.overlap(class1));
	}

	@Test
	public void testImmediatelyBeforeAndAfter() {
		MeetingTime class1 = new MeetingTime(2, 8, 5, 2, 10, 20);
		MeetingTime class2 = new MeetingTime(2, 10, 21, 2, 11, 30);

		Assert.assertFalse(class1.overlap(class2));
		Assert.assertFalse(class2.overlap(class1));
	}
}
