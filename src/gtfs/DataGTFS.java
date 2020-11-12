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


import javafx.stage.FileChooser;
import javafx.stage.Stage;

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

	private HashMap<String, List> stopsOnTripID;


	public DataGTFS(){
		routes = new ArrayList<Route>();
		stops = new ArrayList<Stop>();
		stopTimes = new ArrayList<StopTime>();
		trips = new ArrayList<Trip>();
		stopsOnTripID = new HashMap<>();
	}

	public List<Route> getAllRoutes(){
		return routes;
	}

	public List<Stop> getAllStops(){
		return stops;
	}

	public List<StopTime> getAllStopTimes(){
		return stopTimes;
	}

	public List<Trip> getAllTrips(){
		return trips;
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

	public Stop getStop(int stop_id){
		Stop stop = null;
		Iterator iter = stops.iterator();
		while(iter.hasNext() && stop == null){
			Stop currentStop = (Stop) iter.next();
			if(currentStop.getStopID() == stop_id){
				stop = currentStop;
			}
		}
		return stop;
	}


	public void generateStopOnTrip(){
		List<Stop> stops = new ArrayList<>();
		Iterator iter = stopTimes.iterator();
		String currentID = "";
		while(iter.hasNext()) {
			StopTime r = (StopTime) iter.next();
			if(currentID.equals("")){
				currentID = r.getTripID();
			}
			if (!currentID.equals(r.getTripID())){
				stopsOnTripID.put(currentID, stops);
				stops = new ArrayList<>();
				currentID = r.getTripID();
			}
			Stop stop = getStop(r.getStopID());
			if (!stops.contains(stop)){
				stops.add(stop);
			}
		}
	}

	public List<Stop> getAllStopsOnTrip (String trip_id) {
		return stopsOnTripID.get(trip_id);
	}

	public List<StopTime> getAllTimesOfStopID (int stop_id){
		List<StopTime> stopIdTimes = new ArrayList<>();
		for (StopTime r : stopTimes) {
			if (r.getStopID() == stop_id){
				stopIdTimes.add(r);
			}
		}
		return stopIdTimes;
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
			validateRouteLine(read.nextLine());
		}
	}

	public void setStops(File stopFile) throws FileNotFoundException {
		stops.clear();
		FileInputStream fileInputStream = new FileInputStream(stopFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		String line = read.nextLine();
		validateStopHeader(line);
		while (read.hasNextLine()) {
			validateStopLine(read.nextLine());
		}
	}

	public void setStopTime(File stopTimesFile) throws FileNotFoundException {
		stopTimes.clear();
		FileInputStream fileInputStream = new FileInputStream(stopTimesFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		validateTimeHeader(read.nextLine());
		while (read.hasNextLine()) {
			validateTimesLine(read.nextLine());
		}
	}

	public void setTrips(File tripsFile) throws FileNotFoundException {
		trips.clear();
		FileInputStream fileInputStream = new FileInputStream(tripsFile);
		Scanner read = new Scanner(fileInputStream).useDelimiter(",");
		validateTripHeader(read.nextLine());
		while (read.hasNextLine()) {
			validateTripLine(read.nextLine());
		}

	}

	private int validateTimesLine(String line){
		Scanner in = new Scanner(line).useDelimiter(",");
		String tripID = in.next();
		String arrivalTime = in.next();
		String departureTime = in.next();
		String stopID = in.next();
		String stopSequence = in.next();
		if(tripID.equals("") || stopID.equals("") || stopSequence.equals("")){
			throw new IllegalArgumentException("Stop Times must include trip_id, stop_id, and stop_sequence");
		}
		String headsign = in.next();
		String pickup_type_string = in.next();
		int pickup_type = 0;
		try{
			pickup_type = Integer.parseInt(pickup_type_string);
		} catch (NumberFormatException e){

		}
		int drop_off_type = 0;
		try {
			String drop_off_type_string = in.next();
			try {
				drop_off_type = Integer.parseInt(drop_off_type_string);
			} catch (NullPointerException e) {

			}
		} catch (NoSuchElementException e){

		}
		stopTimes.add(new StopTime(tripID, arrivalTime, departureTime,
				Integer.parseInt(stopID),
				Integer.parseInt(stopSequence),
				headsign,
				pickup_type,
				drop_off_type));
		return Integer.parseInt(stopID);
	}

	private void validateStopLine(String line){
		Scanner in = new Scanner(line).useDelimiter(",");
		String stopID = in.next();
		String stopName = in.next();
		String stopDesc = in.next();
		String stopLat = in.next();
		String stopLon = in.next();
		if(stopID.equals("") || stopLat.equals("") || stopLon.equals("")){
			throw new IllegalArgumentException("Stop must contain stop_id, stop_lat, and stop_lon.");
		}
		stops.add(new Stop(Integer.parseInt(stopID), stopName, stopDesc, stopLat, stopLon));
	}

	private void validateTripLine(String line){
		Scanner in = new Scanner(line).useDelimiter(",");
		String routeID = in.next();
		String serviceID = in.next();
		String tripID = in.next();
		if(routeID.equals("") || tripID.equals("")){
			throw new IllegalArgumentException("Trip must have both a route_id and trip_id");
		}
		String headsign = in.next();
		String direction_id_string = in.next();
		int direction_id = 0;
		try {
			direction_id = Integer.parseInt(direction_id_string);
		} catch (NumberFormatException e){

		}
		String block_id_string = in.next();
		int block_id = 0;
		try {
			block_id = Integer.parseInt(block_id_string);
		} catch (NumberFormatException e){

		}
		trips.add(new Trip(routeID, serviceID, tripID,
				headsign,
				direction_id,
				block_id,
				in.next()));
	}

	private void validateRouteLine(String line){
		Scanner in = new Scanner(line).useDelimiter(",");
		String routeID = in.next();
		String agencyID = in.next();
		String routeShortName = in.next();
		String routeLongName = in.next();
		String routeDesc = in.next();
		String routeType = in.next();
		String routeURL = in.next();
		String routeColor = in.next();
		String routeTextColor = "";
		if(routeID.equals("") || routeColor.equals("")){
			throw new IllegalArgumentException("Both a route ID and route color are required to make a route.");
		}
		try {
			routeTextColor = in.next();
		} catch (NoSuchElementException e){
			//used to skip unnecessary fail state
		}
		routes.add(new Route(routeID, agencyID, routeShortName, routeLongName, routeDesc,
				Integer.parseInt(routeType), routeURL, routeColor, routeTextColor));
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
			throw new IllegalArgumentException("Stop Time header is invalid");
		}
	}

	/**
	 * used for downloading files
	 *
	 * @author Andrew Budreck
	 */
	private void validateRouteHeader(String header) throws IllegalArgumentException{
		if (!header.equals(routeHeader)){
			throw new IllegalArgumentException("Stop header is invalid");
		}
	}

	/**
	 * used for downloading files
	 *
	 * @author Andrew Budreck
	 */
	public void exportRoutes(File output) throws FileNotFoundException {
		String list = "route_id,agency_id,route_short_name,route_long_name,route_desc,route_type,route_url,route_color,route_text_color\n";
		PrintWriter writer = new PrintWriter(output);
		for (Route r:routes
			 ) {
			list += r.toString() + "\n";
		}

		writer.print(list);
		writer.close();

	}

	/**
	 * used for downloading files
	 *
	 * @author Andrew Budreck
	 */
	public void exportStops(File output) throws FileNotFoundException {
		String list = "stop_id,stop_name,stop_desc,stop_lat,stop_lon\n";
		PrintWriter writer = new PrintWriter(output);
		for (Stop r:stops
		) {
			list += r.toString() + "\n";
		}

		writer.print(list);
		writer.close();
	}

	/**
	 * used for downloading files
	 *
	 * @author Andrew Budreck
	 */
	public void exportTrips(File output) throws FileNotFoundException {
		String list = "route_id,service_id,trip_id,trip_headsign,direction_id,block_id,shape_id\n";
		PrintWriter writer = new PrintWriter(output);
		for (Trip r:trips
		) {
			list += r.toString() + "\n";
		}

		writer.print(list);
		writer.close();
	}

	/**
	 * used for downloading files
	 *
	 * @author Andrew Budreck
	 */
	public void exportStopTimes(File output) throws FileNotFoundException {
		String list = "trip_id,arrival_time,departure_time,stop_id,stop_sequence,stop_headsign,pickup_type,drop_off_type\n";
		PrintWriter writer = new PrintWriter(output);
		for (StopTime r:stopTimes
		) {
			list += r.toString() + "\n";
		}

		writer.print(list);
		writer.close();


	}

	public Stop getStopValue(int i){
		return stops.get(i);
	}

	public StopTime getStopTimeValue(int i){
		return stopTimes.get(i);
	}

	public Trip getTripValue(int i){
		return trips.get(i);
	}

	public Route getRouteValue(int i){
		return routes.get(i);
	}



}