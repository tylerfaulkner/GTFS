/*
Copyright 2020 MSOE

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or
substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner, Andrew Budreck
 * Created: 10/08/2020
 */
package gtfs;


import java.util.ArrayList;

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

    /**
     *
     *
     * @author Andrew Budreck
     */
    public void edit(String valueOf, String newValue)
    {
        if(tripID.equals(valueOf)){
            tripID = newValue;
        }
        else if(arrivalTime.equals(valueOf)){
            arrivalTime = newValue;
        }
        else if(departureTime.equals(valueOf)){
            departureTime = newValue;
        }
        else if((""+ stopID).equals(valueOf)){
            stopID = Integer.parseInt(newValue);
        }
        else if ((stopSequence + "").equals(valueOf)){
            stopSequence = Integer.parseInt(newValue);
        }
        else if (stopHeadsign.equals(valueOf)){
            stopHeadsign = newValue;
        }
        else if (("" + pickUpType).equals(valueOf)){
            pickUpType = Integer.parseInt(newValue);

        }
        else if (("" + dropOffType).equals(valueOf)){
            dropOffType = Integer.parseInt(newValue);

        }

    }

    /**
     *
     *
     * @author Andrew Budreck
     */
    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        data.add(tripID);
        data.add(arrivalTime);
        data.add(departureTime);
        data.add(stopID + "");
        data.add(stopSequence + "");
        data.add(stopHeadsign);
        data.add(pickUpType + "");
        data.add(dropOffType + "");

        return data;

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

        if (!tripID.isEmpty()) {
            output += tripID;
        }
        output += ",";
        if (!arrivalTime.isEmpty()) {
            output += arrivalTime;
        }
        output += ",";
        if (!departureTime.isEmpty()) {
            output += departureTime;
        }
        output += ",";
        output += stopID;
        output += ",";

        if (stopSequence != 0) {
            output += stopSequence;
        }
        output += ",";
        if (stopHeadsign.isEmpty()) {
            output += stopHeadsign;
        }
        output += ",";
        output += stopHeadsign;
        output += ",";
        output += dropOffType;
        output += dropOffType;

        return output+"\n";
    }

}