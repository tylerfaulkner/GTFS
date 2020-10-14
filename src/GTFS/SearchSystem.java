package GTFS;


import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:06 AM
 */
public class SearchSystem {

	public DataGTFS m_DataGTFS;

	private File stopFile;
	private File timesFile;
	private File routesFile;
	private File tripsFile;

	public SearchSystem(){
		m_DataGTFS = new DataGTFS();
	}

	/**
	 * 
	 * @param trip_id
	 */
	public void getAverageSpeed(String trip_id){

	}

	/**
	 * 
	 * @param trip_id
	 */
	public void getDistanceTrip(String trip_id){

	}

	/**
	 * 
	 * @param stop_id
	 */
	public void getTotalTripOfStop(String stop_id){

	}

	/**
	 * 
	 * @param route_id
	 */
	public void plotGPSCoordinates(String route_id){

	}

	/**
	 * 
	 * @param routeID
	 */
	public void poltCurrentLoaction(String routeID){

	}

	/**
	 * 
	 * @param id
	 * @param type
	 */
	public void search(String id, String type){

	}

	/**
	 * 
	 * @param id
	 */
	private String setSearchType(String id){
		return "";
	}

	/**
	 * 
	 * @param trips
	 */
	private void sortTrips(List<Trip> trips){

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

	private void setRoutes(File routes) {
		try {
			m_DataGTFS.setRoutes(routes);
		} catch (NullPointerException e){
			System.out.println("No route file found.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void setStops(File stops) {
		try {
			m_DataGTFS.setStops(stops);
		} catch (NullPointerException e){
			System.out.println("No stop file found.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){

		}
	}

	private void setStopTime(File stopTime) {
		try {
			m_DataGTFS.setStopTime(stopTime);
		} catch (NullPointerException e){
			System.out.println("No stop times file found.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void setTrips(File trips) {
		try {
			m_DataGTFS.setTrips(trips);
		} catch (NullPointerException e){
			System.out.println("No trips file found.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void uploadFiles(){
		setStops(stopFile);
		setStopTime(timesFile);
		setTrips(tripsFile);
		setRoutes(routesFile);
		Alert alert = new Alert(Alert.AlertType.INFORMATION, "The upload process has been " +
				"completed successfully.");
		alert.setHeaderText("Upload Complete");
		alert.showAndWait();
	}
}