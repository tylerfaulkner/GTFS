/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner, Andrew Budreck
 * Created: 10/08/2020
 */
package gtfs;


/**
 * used to store stop time information
 *
 * @author Andrew Budreck, Tyler Faulkner
 */
public class StopTime {

    private String tripID;
    private String arrivalTime;
    private String departureTime;
    private int stopID;
    private int stopSequence;
    private String stopHeadsign;
    private int pickUpType;

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getStopHeadsign() {
        return stopHeadsign;
    }

    public int getPickUpType() {
        return pickUpType;
    }

    public int getDropOffType() {
        return dropOffType;
    }

    private int dropOffType;


    /**
     * used to create new stop obj using a file
     *
     * @param tripID
     * @param arrivalTime
     * @param departureTime
     * @param stopID
     * @param stopSequence
     * @param stopHeadsign
     * @param pickUpType
     * @param dropOffType
     */
    public StopTime(String tripID, String arrivalTime, String departureTime, int stopID,
                    int stopSequence, String stopHeadsign, int pickUpType, int dropOffType) {
        this.tripID = tripID;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stopID = stopID;
        this.stopSequence = stopSequence;
        this.stopHeadsign = stopHeadsign;
        this.pickUpType = pickUpType;
        this.dropOffType = dropOffType;
    }

    public int getStopID() {
        return stopID;
    }

    public int getStopSequence() {
        return stopSequence;
    }

    public String getTripID() {
        return tripID;
    }

    public String toString(){
        String output = "";


        return output;
    }

}