package GTFS;


/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:13 AM
 */
public class Trip {

	private String routeID;
	private String serviceID;
	private String tripID;


	/**
	 * 
	 * @param routeID
	 * @param serviceID
	 * @param tripID
	 */
	public Trip(String routeID, String serviceID, String tripID){
		this.routeID = routeID;
		this.serviceID = serviceID;
		this.tripID = tripID;
	}

	public String getRouteID(){
		return "";
	}

	public String getSerciveID(){
		return "";
	}

	public String getTripID(){
		return "";
	}

}