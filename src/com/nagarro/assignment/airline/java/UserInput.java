package com.nagarro.assignment.airline.java;

import java.util.Scanner;

public class UserInput {
	String flightDesLoc;
	String flightSourceLoc;
	String flightDate;
	String flightSeatClass;
	String sortPreference;
		
	void searchInputs() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Airline search");
		System.out.println("Enter three Character Departure Location Code (AAA) ");
		this.flightSourceLoc = sc.nextLine();
		System.out.println("Enter three Character Destination Location Code (AAA) ");
		this.flightDesLoc = sc.nextLine();
		System.out.println("Enter Date of travel in DD-MM-YYYY format ");
		this.flightDate = sc.nextLine();
		System.out.println("Enter Class B = Buiseness & E = Economical ");
		this.flightSeatClass = sc.nextLine();
		System.out.println("Enter Sorting preference F for Fares and T for fare and Time");
		this.sortPreference = sc.nextLine();
		sc.close();
	}
}
