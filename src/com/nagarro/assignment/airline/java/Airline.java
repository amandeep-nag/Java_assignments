package com.nagarro.assignment.airline.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

public class Airline {
	String flightNo;
	String depLoc;
	String arrLoc;
	Date validTill;
	String flightTime;
	String flightDur;
	double baseFare;
	char seatAvailabilty;
	String seatClass;
	
	public Airline(String flightNo, String depLoc, String arrLoc,
			Date validTill, String flightTime, String flightDur,
			double baseFare, char seatAvailabilty, String seatClass) {
		this.flightNo = flightNo;
		this.depLoc = depLoc;
		this.arrLoc = arrLoc;
		this.validTill = validTill;
		this.flightTime = flightTime;
		this.flightDur = flightDur;
		this.baseFare = baseFare;
		this.seatAvailabilty = seatAvailabilty;
		this.seatClass = seatClass;
	}
	
	double getFare(String seatClassSelected) {
		if (seatClassSelected.equalsIgnoreCase("E")) {
			return this.baseFare;
		}
		else
			return this.baseFare + (this.baseFare * 40 / 100);
	}
	
	boolean checkAvailability(UserInput userinput) {
		
		boolean isAvailable = false;
		Date dt = null;
		try {
			dt = new SimpleDateFormat("dd-MM-yyyy").parse(userinput.flightDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if ((this.depLoc.equals(userinput.flightSourceLoc)) && 
				(this.arrLoc.equals(userinput.flightDesLoc)) && 
				this.seatClass.contains(userinput.flightSeatClass) && 
				(this.validTill.compareTo(dt)>=0) && 
				(Character.toString(this.seatAvailabilty).equalsIgnoreCase("y"))) {
			isAvailable = true;
		}
		
		return isAvailable;		
	}
}


class SortbyFare implements Comparator<Airline> 
{ 
    // Used for sorting in ascending order 
    public int compare(Airline a, Airline b) 
    { 
        return (int) (a.baseFare - b.baseFare); 
    } 
} 

class SortbyDuration implements Comparator<Airline> 
{ 
    // Used for sorting in ascending order 
    public int compare(Airline a, Airline b) 
    {
    	double firstFlightDur = Double.parseDouble(a.flightDur);
    	double secondFlightDur = Double.parseDouble(b.flightDur);
        return (int) (firstFlightDur - secondFlightDur); 
    } 
} 
