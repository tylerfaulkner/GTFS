package GTFS;


/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:05 AM
 */
public class Route {

	private String routeID;

	public Route(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param routeID
	 */
	public void Route(String routeID){
		this.routeID = routeID;
	}

	public String getRouteID(){
		return routeID;
	}

}