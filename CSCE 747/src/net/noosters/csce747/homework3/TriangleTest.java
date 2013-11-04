package net.noosters.csce747.homework3;

import junit.framework.Assert;
import net.noosters.csce747.homework3.TriangleSimple.TriangleType;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void testIsTriangleFail() {
		Assert.assertEquals(TriangleSimple.isTriangle(1, 2, 3), false);
	}
	
	@Test
	public void testIsTriangleSuccess() {
		Assert.assertEquals(TriangleSimple.isTriangle(3, 4, 5), true);
	}

	@Test
	public void testGetTriangleTypeIsosceles() {
		Assert.assertEquals(TriangleSimple.getTriangleType(2, 2, 3), TriangleType.ISOSCELES);
	}
	
	@Test
	public void testGetTriangleTypeScalane() {
		Assert.assertEquals(TriangleSimple.getTriangleType(3, 4, 5), TriangleType.SCALENE);
	}

	@Test
	public void testGetTriangleTypeEquilateral() {
		Assert.assertEquals(TriangleSimple.getTriangleType(5, 5, 5), TriangleType.EQUILATERAL);
	}
}
