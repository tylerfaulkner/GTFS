/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner, Andrew Budreck
 * Created: 10/08/2020
 */
package gtfs;


import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * used to search the data base for information to display to the user
 *
 * @author Andrew Budreck, Tyler Faulkner
 * @version 1.0
 */
public class SearchSystem {

    private boolean missingFiles = false;

    public DataGTFS dataGTFS;
    private File stopFile;
    private File timesFile;
    private File routesFile;
    private File tripsFile;

    /** used to create a new data gtfs object
     * @author Andrew Budreck, Tyler Faulkner
     */
    public SearchSystem() {
        dataGTFS = new DataGTFS();
    }

    /** to be made
     * @param tripId
     */
    public void getAverageSpeed(String tripId) {

    }

    /** to be made
     * @param tripId
     */
    public void getDistanceTrip(String tripId) {

    }

    /** Display the number of trips each stop is found on.
     * @param
     * @return
     */
    public int getTotalTripOfStop(int stop_id) {
        List<String> tripIDs = new ArrayList<>();
        List<StopTime> times = dataGTFS.getAllStopTimes();
        for (StopTime time: times){
            if(time.getStopID() == stop_id && !tripIDs.contains(time.getTripID())){
                tripIDs.add(time.getTripID());
            }
        }
        return tripIDs.size();
    }

    public ArrayList<String> searchRoutesWithStopID(int stopID){
        List<Trip> trips = dataGTFS.getAllTrips();
        List<StopTime> stopTimes = dataGTFS.getAllStopTimes();
        ArrayList<String> tripId = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        for (StopTime r:stopTimes) {
            if (r.getStopID() == stopID){
                tripId.add(r.getTripID());
            }
        }

        for (Trip r:trips) {
            if (tripId.contains(r.getTripID())){
                output.add(r.getTripID());
            }
        }

        return output;
    }

    public ArrayList<String> searchClosestTimeWithStopID(int stopID){
        long closestTime = 0;
        List<Trip> trips = dataGTFS.getAllTrips();
        List<StopTime> stopTimes = dataGTFS.getAllStopTimes();
        ArrayList<String> tripId = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        Date date = new Date();
//        String time = new stopTimes.get(0).getArrivalTime().toString();
        for (StopTime r:stopTimes) {
//            if (closerTo()){
//                closestTime =
//            }
        }

        return output;
    }

    public boolean closerTo(long time, long shortest){
        return false;
    }

    /** to be made
     * @param routeId
     */
    public void plotGPSCoordinates(String routeId) {

    }

    /** to be made
     * @param routeID
     */
    public void poltCurrentLoaction(String routeID) {

    }

    /** to be made
     * @param id
     * @param type
     */
    public void search(String id, String type) {

    }

    /** to be made
     * @param id
	 * @return  tbd
     */
    private String setSearchType(String id) {
        return "";
    }

    /** to be made
     * @param trips
     */
    private void sortTrips(List<Trip> trips) {

    }

    public void setRoutesFile(File routesFile) {
        this.routesFile = routesFile;
    }

    public File getRoutesFile() {
        return routesFile;
    }

    public void setStopFile(File stopFile) {
        this.stopFile = stopFile;
    }

    public File getStopFile() {
        return stopFile;
    }

    public void setTimesFile(File timesFile) {
        this.timesFile = timesFile;
    }

    public File getTimesFile() {
        return timesFile;
    }

    public void setTripsFile(File tripsFile) {
        this.tripsFile = tripsFile;
    }

    public File getTripsFile() {
        return tripsFile;
    }

    public List getStopsList(){
        return dataGTFS.getAllStops();
    }

    private void setRoutes(File routes) {
        try {
            dataGTFS.setRoutes(routes);
        } catch (NullPointerException e) {
            missingFiles = true;
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The" +
					" route file has either been moved or " +
                    "deleted from your system since being selected.");
            alert.showAndWait();
        }
    }

    private void setStops(File stops) {
        try {
            dataGTFS.setStops(stops);
        } catch (NullPointerException e) {
            missingFiles = true;
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The route" +
					" file has either been moved or " +
                    "deleted from your system since being selected.");
            alert.showAndWait();
        }
    }

    private void setStopTime(File stopTime) {
        try {
            System.out.println("test");
            dataGTFS.setStopTime(stopTime);
            System.out.println("ytest");
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The " +
					"route file has either been moved or " +
                    "deleted from your system since being selected.");
            alert.showAndWait();
        }
    }

    private void setTrips(File trips) {
        try {
            dataGTFS.setTrips(trips);
        } catch (NullPointerException e) {
            missingFiles = true;
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The" +
					" route file has either been moved or " +
                    "deleted from your system since being selected.");
            alert.showAndWait();
        }
    }

	/** used for uploading files
	 * @author Tyler Faulkner
	 */
    public void uploadFiles() {

        if (stopFile != null){
            setStops(stopFile);
        }
        if (timesFile != null) {
            setStopTime(timesFile);
        }
        if (tripsFile != null) {
            setTrips(tripsFile);
        }
        if (routesFile != null) {
            setRoutes(routesFile);
        }
        if (missingFiles) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
					"Not all GTFS files were uploaded. " +
                    "Some program functionality may not be available.");
            alert.setHeaderText("Missing Files");
            alert.show();
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "The upload process has been " +
                "completed successfully.");
        alert.setHeaderText("Upload Complete");
        alert.showAndWait();
    }
}