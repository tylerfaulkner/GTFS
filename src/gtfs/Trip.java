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

/** used to store trip information for the data gtfs
 * @author Andrew Budreck, Tyler Faulkner
 *
 */
public class Trip {

    private String routeID;
    private String serviceID;
    private String tripID;

    public String getTripHeadSign() {
        return tripHeadSign;
    }

    public int getDirectionID() {
        return directionID;
    }

    public int getBlockID() {
        return blockID;
    }

    public String getShapeID() {
        return shapeID;
    }

    private String tripHeadSign;
    private int directionID;
    private int blockID;
    private String shapeID;


    /** used to create a trip object to be saved ot a list
	 *
	 * @author Andrew Budreck, Tyler Faulkner
     * @param routeID route id is an id given to a route
     * @param serviceID id given to for a service
     * @param tripID trips for the given route
	 * @param  tripHeadSign used to store trip head sign
	 * @param directionID used to store direction id
	 * @param blockID used to store block id
	 * @param shapeID used to store shape id
     */
    public Trip(String routeID, String serviceID, String tripID, String tripHeadSign,
                int directionID, int blockID, String shapeID) {
        this.routeID = routeID;
        this.serviceID = serviceID;
        this.tripID = tripID;
        this.tripHeadSign = tripHeadSign;
        this.directionID = directionID;
        this.blockID = blockID;
        this.shapeID = shapeID;
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
        else if(routeID.equals(valueOf)){
            routeID = newValue;
        }
        else if(serviceID.equals(valueOf)){
            serviceID = newValue;
        }
        else if((tripID).equals(valueOf)){
            tripID = newValue;
        }
        else if (tripHeadSign.equals(valueOf)){
            tripHeadSign = newValue;
        }
        else if (("" + directionID).equals(valueOf)){
            directionID = Integer.parseInt(newValue);
        }
        else if (("" + blockID).equals(valueOf)){
            blockID = Integer.parseInt(newValue);

        }
        else if (shapeID.equals(valueOf)){
            shapeID = newValue;

        }

    }
    /**
     *
     *
     * @author Andrew Budreck
     */

    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        data.add(routeID);
        data.add(serviceID);
        data.add(tripID);
        data.add(tripHeadSign);
        data.add(directionID + "");
        data.add(blockID + "");
        data.add(shapeID);


        return data;

    }
    public String getRouteID() {
        return routeID;
    }

    public String getServiceID() {
        return serviceID;
    }

    public String getTripID() {
        return tripID;
    }

    public String toString(){
        String output = "";
        if (!routeID.isEmpty()) {
            output += routeID;
        }
        output += ",";

        if (!serviceID.isEmpty()) {
            output += serviceID;
        }
        output += ",";
        if (!tripID.isEmpty()) {
            output += tripID;
        }
        output += ",";
        if (!tripHeadSign.isEmpty()) {
            output += tripHeadSign;
        }
        output += ",";
        output += directionID;
        output += ",";
        if (blockID == 0) {
            output += blockID;
        }
        output += ",";
        if (!shapeID.isEmpty()) {
            output += shapeID;
        }
        output += ",";

        return output;
    }

}