package com.nagarro.assignment.airline.java;

public class Main {

	public static void main(String[] args) {
		ReadFile rf = new ReadFile();
		rf.readAllFilesInFolder();
		for(Airline flight: ReadFile.allFlights) {
			System.out.println(flight.validTill);
		}
		UserInput ui = new UserInput();
		ui.searchInputs();
		SearchFlight sf = new SearchFlight();
		sf.searchFlightsAndShowSorted(ui);
	}
}
