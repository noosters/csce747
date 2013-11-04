package net.noosters.csce747.homework3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Jason Isenhower
//CSCE 747 - Homework 3
public class TriangleSimple {
	public enum TriangleType { EQUILATERAL, SCALENE, ISOSCELES };
	
	public static void main(String[] args) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		int sideA, sideB, sideC;
		String[] numberStrings;
		try {
			for (numberStrings = null; 
					numberStrings == null || numberStrings.length != 3;
					numberStrings = input.readLine().split(" ")) {
				System.out.println("Enter 3 integers which are sides of a triangle");
			}
			
			sideA = Integer.parseInt(numberStrings[0]);
			sideB = Integer.parseInt(numberStrings[1]);
			sideC = Integer.parseInt(numberStrings[2]);
			
			System.out.println("Side A is '" + sideA + "'");
			System.out.println("Side B is '" + sideB + "'");
			System.out.println("Side C is '" + sideC + "'");
			
			if (isTriangle(sideA, sideB, sideC)) {
				switch (getTriangleType(sideA, sideB, sideC)) {
				case EQUILATERAL:
					System.out.println("Equilateral");
					break;
				case ISOSCELES:
					System.out.println("Isosceles");
					break;
				case SCALENE:
					System.out.println("Scalene");
					break;
				}
			} else {
				System.out.println("Not a triangle");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Unable to parse input as three numbers");
		}
	}
	
	public static boolean isTriangle(int a, int b, int c) {
		return (a < (b + c) 
				&& b < (a + c) 
				&& c < (a + b));
	}
	
	public static TriangleType getTriangleType(int a, int b, int c) {
		if (a == b && b == c)
			return TriangleType.EQUILATERAL;
		else if (a != b && a != c && b != c)
			return TriangleType.SCALENE;
		else
			return TriangleType.ISOSCELES;
	}
}
