package com.nagarro.assignment.airline.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.*;

public class SearchFlight {
	void searchFlightsAndShowSorted(UserInput userInput) {
		ArrayList<Airline> allFlights = ReadFile.allFlights;
		ArrayList<Airline> filteredFlights = new ArrayList<>();
		filteredFlights = allFlights.stream().filter(flight -> flight.checkAvailability(userInput))
				.collect(Collectors 
                .toCollection(ArrayList::new));
		ArrayList<Airline> sortedFlights = sortFlights(filteredFlights, userInput);
		showFlights(sortedFlights, userInput);
	}
	
	static ArrayList<Airline> sortFlights(ArrayList<Airline> filteredFlights, UserInput userInput) {
		if(userInput.sortPreference.equals("F")) {
			Collections.sort(filteredFlights, new SortbyFare());
		} else {
			Collections.sort(filteredFlights, new SortbyFare()
                    .thenComparing(new SortbyDuration()));
		}
		return filteredFlights;
	}
	
	static void showFlights(ArrayList<Airline> sortedFlights, UserInput userInput) {
		if (sortedFlights.isEmpty()) {
			System.out.println("No flights found");
		}
		else {
			System.out.println("fltNum - Dep - Arr - Time - Dur - Fare - Class");	
			sortedFlights.forEach(flight->System.out.println(flight.flightNo +" - "+ flight.depLoc +" - "+ flight.arrLoc
					+" - "+ flight.flightTime+" - "+flight.flightDur +"hrs - "+
					flight.getFare(userInput.flightSeatClass) +" - "+ userInput.flightSeatClass));
		}
	}
}
