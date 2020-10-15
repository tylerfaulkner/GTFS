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
		List<Route> newRoutes = new ArrayList<>();
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
			newRoutes.add(new Route(routeID, agencyID, routeShortName, routeLongName, routeDesc,
					Integer.parseInt(routeType), routeURL, routeColor, routeTextColor));
		}
		routes = newRoutes;
	}

	public void setStops(File stopFile) throws FileNotFoundException {
		List<Stop> newStops = new ArrayList<>();
		FileInputStream fileInputStream = new FileInputStream(stopFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		read.nextLine();
		while (read.hasNextLine()) {
			Scanner in = new Scanner(read.nextLine()).useDelimiter(",");
			newStops.add(new Stop(Integer.parseInt(in.next()), in.next(), in.next(),
					in.next(), in.next()));
		}
		stops = newStops;
	}

	public void setStopTime(File stopTimesFile) throws FileNotFoundException {
		List<StopTime> newTimes = new ArrayList<>();
		FileInputStream fileInputStream = new FileInputStream(stopTimesFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		read.nextLine();
		while (read.hasNextLine()) {
			Scanner in = new Scanner(read.nextLine()).useDelimiter(",");
			newTimes.add(new StopTime(in.next(), in.next(), in.next(), Integer.parseInt(in.next()),
					Integer.parseInt(in.next()), in.next(), Integer.parseInt(in.next()), Integer.parseInt(in.next())));
		}
		stopTimes = newTimes;
	}

	public void setTrips(File tripsFile) throws FileNotFoundException {
		List<Trip> newTrips = new ArrayList<>();
		FileInputStream fileInputStream = new FileInputStream(tripsFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		read.nextLine();
		while (read.hasNextLine()) {
			Scanner in = new Scanner(read.nextLine()).useDelimiter(",");
			newTrips.add(new Trip(in.next(), in.next(), in.next(), in.next(),
					Integer.parseInt(in.next()), Integer.parseInt(in.next()), in.next()));
		}
		trips = newTrips;
	}
}