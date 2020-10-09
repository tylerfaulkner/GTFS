package GTFS;


/**
 * <b><u>-trip_id : string</u></b>
 * <b><u>-stop_id : string</u></b>
 * <b><u>-stop_sequence : int</u></b>
 * <b>+getTripID(): string</b>
 * <b>+getStopID(): string</b>
 * <b>+getStopSequence(): int</b>
 * test
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:37:07 AM
 */
public class Stop {

	private String stopId;
	private double stopLat;
	private double stopLong;

	/**
	 * 
	 * @param stopId
	 * @param stopLat
	 * @param stopLong
	 */
	public Stop(String stopId, double stopLat, double stopLong){
		this.stopId = stopId;
		this.stopLat = stopLat;
		this.stopLong = stopLong;
	}

	public Double getLat(){
		return stopLat;
	}

	public Double getLong(){
		return stopLong;
	}

	public String getStopID(){
		return stopId;
	}

}