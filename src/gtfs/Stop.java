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

    public String toString(){
        String output = "";
        output += stopId;
        if (!stopName.isEmpty()){
            output += stopName;
        }
        output += ",";
        if (!stopDesc.isEmpty()){
            output += stopDesc;
        }
        output += ",";

        if (!stopLat.isEmpty()){
            output += stopLat;
        }
        output += ",";
        if (!stopLong.isEmpty()){
            output += stopLong;
        }
        output += ",";
        return output;
    }

}