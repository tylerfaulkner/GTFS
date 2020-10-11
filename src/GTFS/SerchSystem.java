package GTFS;


import java.io.File;
import java.util.List;

/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:06 AM
 */
public class SerchSystem {

	public DataGTFS m_DataGTFS;

	public SerchSystem(){

	}

	public void finalize() throws Throwable {

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


	public void setRoutes(File routes) {
		m_DataGTFS.setRoutes(routes);
	}

	public void setStops(File stops) {
		m_DataGTFS.setStops(stops);
	}

	public void setStopTime(File stopTime) {
		m_DataGTFS.setStopTime(stopTime);
	}

	public void setTrips(File trips) {
		m_DataGTFS.setTrips(trips);
	}
}