package GTFS;


import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:02 AM
 */
public class DataGTFS {

	private List<Route> routes;
	private List<Stop> stops;
	private List<StopTime> stopTimes;
	private List<Stop> trips;
	public StopTime m_StopTime;
	public Stop m_Stop;
	public Route m_Route;
	public Trip m_Trip;

	public DataGTFS(){

	}

	public List<Route> getAllRoutes(){
		return null;
	}

	public List<Stop> getAllStops(){
		return null;
	}

	public List<StopTime> getAllStopTimes(){
		return null;
	}

	public List<Trip> getAllTrips(){
		return null;
	}

	/**
	 * 
	 * @param stop_id
	 */
	public List<Route> getRoutesByStop(String stop_id){
		return null;
	}

	/**
	 * 
	 * @param stop_id
	 */
	public List<Route> getStopsOnRoute(String stop_id){
		return null;
	}

	/**
	 * 
	 * @param tripID
	 */
	public List<Stop> getStopsOnTrip(String tripID){
		return null;
	}

	/**
	 * 
	 * @param trip_id
	 */
	public List<Trip> getTripsOfRoute(String trip_id){
		return null;
	}

	/**
	 * 
	 * @param stop_id
	 */
	public List<Trip> getTripsOnStop(String stop_id){
		return null;
	}

	public void setRoutes(File routes) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(routes);
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);


	}

	public void setStops(File stops) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(stops);
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);

	}

	public void setStopTime(File stopTime) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(stopTime);
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
	}

	public void setTrips(File trips) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(trips);
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
	}
}