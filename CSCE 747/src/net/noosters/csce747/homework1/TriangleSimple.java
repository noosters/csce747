package net.noosters.csce747.homework1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Jason Isenhower
//CSCE 747 - Homework 1
public class TriangleSimple {
	
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
			
			if (sideA < (sideB + sideC) && sideB < (sideA + sideC) && sideC < (sideA + sideB)) {
				//then it is a triangle
				if (sideA == sideB && sideB == sideC) {
					System.out.println("Equilateral");
				} else if (sideA != sideB && sideA != sideC && sideB != sideC) {
					System.out.println("Scalene");
				} else {
					System.out.println("Isosceles");
				}
			} else {
				//not a triangle, dummy
				System.out.println("Not a triangle");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Unable to parse input as three numbers");
		}
	}
}
