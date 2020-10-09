package GTFS;


/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:08 AM
 */
public class StopTime {

	private String stopId;
	private int stopSequence;
	private String tripId;


	/**
	 * 
	 * @param stopId
	 * @param stopSequence
	 * @param tripId
	 */
	public StopTime(String stopId, int stopSequence, String tripId){
		this.stopId = stopId;
		this.stopSequence = stopSequence;
		this.tripId = tripId;
	}

	public String getStopID(){
		return "";
	}

	public String getStopSequence(){
		return "";
	}

	public String getTripID(){
		return "";
	}

}