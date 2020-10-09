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

	private string stopId;
	private double stopLat;
	private double stopLong;

	public Stop(){

	}

	public void finalize() throws Throwable {

	}

	/**
	 * 
	 * @param stopId
	 * @param stopLat
	 * @param stopLong
	 */
	public Stop(String stopId, double stopLat, double stopLong){

	}

	public Double getLat(){
		return 0;
	}

	public Double getLong(){
		return 0;
	}

	public String getStopID(){
		return "";
	}

}