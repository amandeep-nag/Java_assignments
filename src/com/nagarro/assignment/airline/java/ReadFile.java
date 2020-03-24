package com.nagarro.assignment.airline.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReadFile {
	private static String csvFolder = "src/com/nagarro/assignment/airline/csvFiles";
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = "\\|";
    public static ArrayList<Airline> allFlights = new ArrayList<>();
    
    public void readFile(String path){
    	int counter = 0;
    	try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] flightDetails = line.split(cvsSplitBy);
                if (counter == 0) {
                	counter++;
                	continue;
                }
                this.addFlightDetailsInList(flightDetails);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static ArrayList<String> getFilesFromFolder() {
		ArrayList<String> filenames = new ArrayList<String>();
		final File folder = new File(csvFolder);		
	    for (final File fileEntry : folder.listFiles()) {	      
	    	if(fileEntry.getName().contains(".csv"))
	    		filenames.add(fileEntry.getName());
	    }
	    return filenames;
	}
    
    public void readAllFilesInFolder(){
    	ArrayList<String> filenames = getFilesFromFolder();
    	for (String fileName : filenames) {
    		final String fullPath = csvFolder + "/" + fileName;
    		this.readFile(fullPath);
    	}
    }
    
    public void addFlightDetailsInList(String[] flightDetails) throws ParseException{
    	String flightNo = flightDetails[0];
    	String depLoc = flightDetails[1];
    	String arrLoc = flightDetails[2];
    	Date validTill = new SimpleDateFormat("dd-MM-yyyy").parse(flightDetails[3]);
    	String flightTime = flightDetails[4];
    	String flightDur = flightDetails[5];
    	double baseFare = Double.parseDouble(flightDetails[6]);
    	char seatAvailabilty = flightDetails[7].charAt(0);
    	String seatClass = flightDetails[8];
    	Airline airlineInfo = new Airline(flightNo, depLoc, arrLoc, validTill, flightTime, flightDur, baseFare, seatAvailabilty, seatClass);
    	allFlights.add(airlineInfo);
    }
}
