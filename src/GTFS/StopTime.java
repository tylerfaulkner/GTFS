/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner
 * Created: 10/08/2020
 */
package GTFS;


/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:08 AM
 */
public class StopTime {

	private String tripID;
	private String arrivalTime;
	private String departureTime;
	private int stopID;
	private int stopSequence;
	private String stopHeadsign;
	private int pickUpType;
	private int dropOffType;


	/**
	 * 
	 * @param stopId
	 * @param stopSequence
	 * @param tripId
	 */
	public StopTime(String tripID, String arrivalTime, String departureTime, int stopID,
					int stopSequence, String stopHeadsign, int pickUpType, int dropOffType){
		this.tripID = tripID;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.stopID = stopID;
		this.stopSequence = stopSequence;
		this.stopHeadsign = stopHeadsign;
		this.pickUpType = pickUpType;
		this.dropOffType = dropOffType;
	}

	public int getStopID(){
		return stopID;
	}

	public int getStopSequence(){
		return stopSequence;
	}

	public String getTripID(){
		return tripID;
	}

}