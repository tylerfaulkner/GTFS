/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner, Andrew Budreck
 * Created: 10/08/2020
 */
package gtfs;


import java.io.*;
import java.util.*;

/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:02 AM
 */
public class DataGTFS {
	private static String tripHeader = "route_id,service_id,trip_id,trip_headsign,direction_id,block_id,shape_id";
	private static String stopHeader = "stop_id,stop_name,stop_desc,stop_lat,stop_lon";
	private static String timesHeader = "trip_id,arrival_time,departure_time,stop_id,stop_sequence,stop_headsign,pickup_type,drop_off_type";
	private static String routeHeader = "route_id,agency_id,route_short_name,route_long_name,route_desc,route_type,route_url,route_color,route_text_color";

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

	public int getStopCount(){
		return stops.size();
	}

	public int getTimeCount(){
		return stopTimes.size();
	}

	public int getTripsCount(){
		return trips.size();
	}

	public int getRoutesCount(){
		return routes.size();
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
		routes.clear();
		FileInputStream fileInputStream = new FileInputStream(routesFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		validateRouteHeader(read.nextLine());
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
	}

	public void setStops(File stopFile) throws FileNotFoundException {
		stops.clear();
		FileInputStream fileInputStream = new FileInputStream(stopFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		validateStopHeader(read.nextLine());
		while (read.hasNextLine()) {
			Scanner in = new Scanner(read.nextLine()).useDelimiter(",");
			stops.add(new Stop(Integer.parseInt(in.next()), in.next(), in.next(),
					in.next(), in.next()));
		}
		stops.addAll(stops);
	}

	public void setStopTime(File stopTimesFile) throws FileNotFoundException {
		stopTimes.clear();
		FileInputStream fileInputStream = new FileInputStream(stopTimesFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		validateTimeHeader(read.nextLine());
		while (read.hasNextLine()) {
			Scanner in = new Scanner(read.nextLine()).useDelimiter(",");
			stopTimes.add(new StopTime(in.next(), in.next(), in.next(), Integer.parseInt(in.next()),
					Integer.parseInt(in.next()), in.next(), Integer.parseInt(in.next()), Integer.parseInt(in.next())));
		}
		stopTimes.addAll(stopTimes);
	}

	public void setTrips(File tripsFile) throws FileNotFoundException {
		trips.clear();
		FileInputStream fileInputStream = new FileInputStream(tripsFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		validateTripHeader(read.nextLine());
		while (read.hasNextLine()) {
			Scanner in = new Scanner(read.nextLine()).useDelimiter(",");
			trips.add(new Trip(in.next(), in.next(), in.next(), in.next(),
					Integer.parseInt(in.next()), Integer.parseInt(in.next()), in.next()));
		}

	}

	private void validateTripHeader(String header) throws IllegalArgumentException{
		if (!header.equals(tripHeader)){
			throw new IllegalArgumentException("Trip header is invalid");
		}
	}

	private void validateStopHeader(String header) throws IllegalArgumentException{
		if (!header.equals(stopHeader)){
			throw new IllegalArgumentException("Stop header is invalid");
		}
	}

	private void validateTimeHeader(String header) throws IllegalArgumentException{
		if (!header.equals(timesHeader)){
			throw new IllegalArgumentException("Stop header is invalid");
		}
	}

	private void validateRouteHeader(String header) throws IllegalArgumentException{
		if (!header.equals(routeHeader)){
			throw new IllegalArgumentException("Stop header is invalid");
		}
	}
}