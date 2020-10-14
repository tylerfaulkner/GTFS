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
	private String tripHeadSign;
	private int directionID;
	private int blockID;
	private String shapeID;


	/**
	 * 
	 * @param routeID
	 * @param serviceID
	 * @param tripID
	 */
	public Trip(String routeID, String serviceID, String tripID, String tripHeadSign,
				int directionID, int blockID, String shapeID){
		this.routeID = routeID;
		this.serviceID = serviceID;
		this.tripID = tripID;
		this.tripHeadSign = tripHeadSign;
		this.directionID = directionID;
		this.blockID = blockID;
		this.shapeID = shapeID;
	}

	public String getRouteID(){
		return routeID;
	}

	public String getServiceID(){
		return serviceID;
	}

	public String getTripID(){
		return tripID;
	}

}