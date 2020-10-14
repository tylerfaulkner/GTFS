package GTFS;


import java.io.*;
import java.util.*;

/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:02 AM
 */
public class DataGTFS {

	private List<Route> routes;
	private List<Stop> stops;
	private List<StopTime> stopTimes;
	private List<Trip> trips;


	public DataGTFS(){
		routes = new ArrayList<Route>();
		stops = new ArrayList<Stop>();
		stopTimes = new ArrayList<StopTime>();
		trips = new ArrayList<Trip>();
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

	public void setRoutes(File routesFile) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(routesFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		read.nextLine(); //used to skip header line
		while (read.hasNextLine()) {
			Scanner in = new Scanner(read.nextLine()).useDelimiter(",");
			String routeID = in.next();
			String agencyID = in.next();
			String routeShortName = in.next();
			String routeLongName = in.next();
			String routeDesc = in.next();
			String routeType = in.next();
			String routeURL = in.next();
			String routeColor = in.next();
			String routeTextColor = "";
			try {
				routeTextColor = in.next();
			} catch (NoSuchElementException e){

			}
			routes.add(new Route(routeID, agencyID, routeShortName, routeLongName, routeDesc,
					Integer.parseInt(routeType), routeURL, routeColor, routeTextColor));
		}
		System.out.println(routes.get(25).getRouteID());
	}

	public void setStops(File stopFile) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(stopFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		read.nextLine();
		while (read.hasNextLine()) {
			Scanner in = new Scanner(read.nextLine()).useDelimiter(",");
			stops.add(new Stop(Integer.parseInt(in.next()), in.next(), in.next(),
					in.next(), in.next()));
		}
	}

	public void setStopTime(File stopTimesFile) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(stopTimesFile);
		Scanner in = new Scanner(fileInputStream).useDelimiter(",");

	}

	public void setTrips(File tripsFile) throws FileNotFoundException {
		FileInputStream fileInputStream = new FileInputStream(tripsFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		read.nextLine();
		while (read.hasNextLine()) {
			Scanner in = new Scanner(read.nextLine()).useDelimiter(",");
			stops.add(new Stop(Integer.parseInt(in.next()), in.next(), in.next(),
					in.next(), in.next()));
		}
	}
}