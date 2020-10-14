/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner
 * Created: 10/08/2020
 */
package GTFS;


/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:05 AM
 */
public class Route {

	private String routeID;
	private String agencyID;
	private String routeShortName;
	private String routeLongName;
	private String routeDesc;
	private int routeType;
	private String routeURL;
	private String routeColor;
	private String routeTextColor;

	/**
	 * 
	 * @param routeID
	 */
	public Route(String routeID, String agencyID, String routeShortName, String routeLongName, String routeDesc,
					  int routeType, String routeURL, String routeColor, String routeTextColor){
		this.routeID = routeID;
		this.agencyID = agencyID;
		this.routeShortName = routeShortName;
		this.routeLongName = routeLongName;
		this.routeDesc = routeDesc;
		this.routeType = routeType;
		this.routeURL = routeURL;
		this.routeColor = routeColor;
		this.routeTextColor = routeTextColor;
	}

	public String getRouteID(){
		return routeID;
	}

}