/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner, Andrew Budreck
 * Created: 10/08/2020
 */
package gtfs;


import javafx.scene.control.Alert;
import org.junit.After;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.sql.Time;
import java.util.*;

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

    /**
     * used to create a new data gtfs object
     *
     * @author Andrew Budreck, Tyler Faulkner
     */
    public SearchSystem() {
        dataGTFS = new DataGTFS();
    }

    /**
     * to be made
     *
     * @param tripId
     */
    public void getAverageSpeed(String tripId) {

    }

    /**
     * to be made
     *
     * @param tripId
     */
    public void getDistanceTrip(String tripId) {

    }

    /**
     * Display the number of trips each stop is found on.
     *
     * @param
     * @return
     */
    public int getTotalTripOfStop(int stop_id) {
        List<String> tripIDs = new ArrayList<>();
        List<StopTime> times = dataGTFS.getAllStopTimes();
        for (StopTime time : times) {
            if (time.getStopID() == stop_id && !tripIDs.contains(time.getTripID())) {
                tripIDs.add(time.getTripID());
            }
        }
        return tripIDs.size();
    }

    /**
     * finds all route ids given a stop id
     *
     * @author Andrew Budreck
     */
    public ArrayList<String> searchRoutesWithStopID(int stopID) {
        List<Trip> trips = dataGTFS.getAllTrips();
        List<StopTime> stopTimes = dataGTFS.getAllStopTimes();
        ArrayList<String> tripId = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();
        for (StopTime r : stopTimes) {
            if (r.getStopID() == stopID) {
                tripId.add(r.getTripID());
            }
        }

        for (Trip r : trips) {
            if (tripId.contains(r.getTripID())) {
                output.add(r.getRouteID());
            }
        }

        return output;
    }

    /**
     * finds nearest stops times given a stop ID
     *
     * @author Tyler
     */
    public ArrayList<String> searchClosestTimeWithStopID(int stopID) {
        List<StopTime> stopIdTimes = dataGTFS.getAllTimesOfStopID(stopID);
        ArrayList<String> tripIdsBefore = new ArrayList<>();
        ArrayList<String> tripIdsAfter = new ArrayList<>();
        Map<String, Time> arrivalTimes = new HashMap<>();
        for (StopTime times : stopIdTimes){
            arrivalTimes.put(times.getTripID(), Time.valueOf(times.getArrivalTime()));
        }
        Iterator<String> iter = arrivalTimes.keySet().iterator();
        while (iter.hasNext()){
            String currentTrip = iter.next();
            Time currentTime = arrivalTimes.get(currentTrip);
            String timeString = currentTime.toString();
            Time time = new Time(new Date().getTime());
            if (time.compareTo(currentTime) <= 0){
                int i = 0;
                boolean found = false;
                while (i < tripIdsBefore.size() && !found){
                    String compareTrip = tripIdsBefore.get(i);
                    Time compareTime = arrivalTimes.get(compareTrip);
                    if(currentTime.before(compareTime)){
                        tripIdsBefore.set(i, currentTrip);
                        found = true;
                    }
                    i++;
                }
                if(!found){
                    tripIdsBefore.add(currentTrip);
                }
            } else {
                int i = 0;
                boolean found = false;
                while (i < tripIdsAfter.size() && !found){
                    String compareTrip = tripIdsAfter.get(i);
                    Time compareTime = arrivalTimes.get(compareTrip);
                    if(currentTime.before(compareTime)){
                        tripIdsAfter.set(i, currentTrip);
                        found = true;
                    }
                    i++;
                }
                if(!found){
                    tripIdsAfter.add(currentTrip);
                }
            }
        }

        ArrayList<String> tripIds = new ArrayList<>();
        tripIds.addAll(tripIdsBefore);
        tripIds.addAll(tripIdsAfter);

        return tripIds;
    }

    /**
     * to be made
     *
     * @param routeId
     */
    public void plotGPSCoordinates(String routeId) {

    }

    /**
     * to be made
     *
     * @param routeID
     */
    public void poltCurrentLoaction(String routeID) {

    }

    /**
     * to be made
     *
     * @param id
     * @param type
     */
    public void search(String id, String type) {

    }

    /**
     * to be made
     *
     * @param id
     * @return tbd
     */
    private String setSearchType(String id) {
        return "";
    }

    /**
     * to be made
     *
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

    public List getStopsList() {
        return dataGTFS.getAllStops();
    }

    /**
     * imports files from user
     *
     * @author Tyler
     */
    private void setRoutes(File routes) {
        try {
            dataGTFS.setRoutes(routes);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "The routes file has been " +
                    "uploaded successfully.");
            alert.setHeaderText("Routes File Uploaded");
            alert.show();
        } catch (NullPointerException e) {
            missingFiles = true;
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The" +
                    " route file has either been moved or " +
                    "deleted from your system since being selected.");
            alert.showAndWait();
        }
    }

    /**
     * imports files from user
     *
     * @author Tyler
     */
    private void setStops(File stops) {
        try {
            dataGTFS.setStops(stops);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "The stops file has been " +
                    "uploaded successfully.");
            alert.setHeaderText("Stops File Uploaded");
            alert.show();
        } catch (NullPointerException e) {
            missingFiles = true;
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The route" +
                    " file has either been moved or " +
                    "deleted from your system since being selected.");
            alert.showAndWait();
        }
    }

    /**
     * imports files from user
     *
     * @author Tyler
     */
    private void setStopTime(File stopTime) {
        try {
            dataGTFS.setStopTime(stopTime);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "The stop times file has been " +
                    "uploaded successfully.");
            alert.setHeaderText("Stop Times File Uploaded");
            alert.show();
        } catch (NullPointerException e) {

        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The " +
                    "route file has either been moved or " +
                    "deleted from your system since being selected.");
            alert.showAndWait();
        }
    }

    /**
     * imports files from user
     *
     * @author Tyler
     */
    private void setTrips(File trips) {
        try {
            dataGTFS.setTrips(trips);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "The trips file has been " +
                    "uploaded successfully.");
            alert.setHeaderText("Trips File Uploaded");
            alert.show();
        } catch (NullPointerException e) {

        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "The" +
                    " route file has either been moved or " +
                    "deleted from your system since being selected.");
            alert.showAndWait();
        }
    }

    /**
     * used for uploading files
     *
     * @author Tyler Faulkner
     */
    public void uploadFiles() {
        setStops(stopFile);

        setStopTime(timesFile);

        setTrips(tripsFile);

        setRoutes(routesFile);
        if (stopFile == null || timesFile == null || tripsFile == null || routesFile == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION,
                    "Not all GTFS files were uploaded. " +
                            "Some program functionality may not be available.\n" +
                            "Missing files: " + (stopFile == null ? "\nstops" : "" )
                            + (timesFile == null ? "\nstop_times" : "") + (tripsFile == null ? "\ntrips" : "")
                            + (routesFile == null ? "\nroutes" : ""));
            alert.setHeaderText("Missing Files");
            alert.showAndWait();
        }
    }
}