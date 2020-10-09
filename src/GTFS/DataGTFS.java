package GTFS;


/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:02 AM
 */
public class DataGTFS {

	private List<route> routes;
	private List<stop> stops;
	private List<stopTime> stopTimes;
	private List<stop> trips;
	public StopTime m_StopTime;
	public Stop m_Stop;
	public Route m_Route;
	public Trip m_Trip;

	public DataGTFS(){

	}

	public void finalize() throws Throwable {

	}

	public List<route> getAllRoutes(){
		return null;
	}

	public List<stop> getAllStops(){
		return null;
	}

	public List<stop_time> getAllStopTimes(){
		return null;
	}

	public List<trip> getAllTrips(){
		return null;
	}

	/**
	 * 
	 * @param stop_id
	 */
	public list<route> getRoutesByStop(String stop_id){
		return null;
	}

	/**
	 * 
	 * @param stop_id
	 */
	public List<route> getStopsOnRoute(String stop_id){
		return null;
	}

	/**
	 * 
	 * @param tripID
	 */
	public List<stop> getStopsOnTrip(String tripID){
		return null;
	}

	/**
	 * 
	 * @param trip_id
	 */
	public List<trip> getTripsOfRoute(String trip_id){
		return null;
	}

	/**
	 * 
	 * @param stop_id
	 */
	public List<trip> getTripsOnStop(String stop_id){
		return null;
	}

}