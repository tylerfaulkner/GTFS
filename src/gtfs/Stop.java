/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner, Andrew Budreck
 * Created: 10/08/2020
 */
package gtfs;


/**
 * <b><u>-trip_id : string</u></b>
 * <b><u>-stop_id : string</u></b>
 * <b><u>-stop_sequence : int</u></b>
 * <b>+getTripID(): string</b>
 * <b>+getStopID(): string</b>
 * <b>+getStopSequence(): int</b>
 * test
 *
 * @author budrecka
 * @version 1.0
 */
public class Stop {

    private int stopId;
    private String stopName;
    private String stopDesc;
    private String stopLat;
    private String stopLong;

    /** on objected used to save stop info and get stop info
     * @param stopId
     * @param stopLat
     * @param stopLong
     */
    public Stop(int stopId, String stopName, String stopDesc, String stopLat, String stopLong) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.stopDesc = stopDesc;
        this.stopLat = stopLat;
        this.stopLong = stopLong;
    }

    public String getLat() {
        return stopLat;
    }

    public String getLong() {
        return stopLong;
    }

    public int getStopID() {
        return stopId;
    }

}