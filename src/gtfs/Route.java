/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner, Andrew Budreck
 * Created: 10/08/2020
 */
package gtfs;


import java.util.ArrayList;

/**
 * on objected used to save route info and get stop info
 *
 * @author Andrew Budreck, Tyler Faulkner
 * @version 1.0
 */
public class Route {

    public String getAgencyID() {
        return agencyID;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public String getRouteDesc() {
        return routeDesc;
    }

    public int getRouteType() {
        return routeType;
    }

    public String getRouteURL() {
        return routeURL;
    }

    public String getRouteColor() {
        return routeColor;
    }

    public String getRouteTextColor() {
        return routeTextColor;
    }

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
     * sets the route information of the object
     *@author Andrew Budreck, Tyler Faulkner
     * @param routeID
     * @param agencyID
     * @param routeShortName
     * @param routeLongName
     * @param routeDesc
     * @param routeType
     * @param routeURL
     * @param routeColor
     * @param routeTextColor
     */
    public Route(String routeID, String agencyID, String routeShortName,
                 String routeLongName, String routeDesc,
                 int routeType, String routeURL, String routeColor, String routeTextColor) {
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
    /**
     *
     *
     * @author Andrew Budreck
     */
    public ArrayList<String> getData(){
        ArrayList<String> data = new ArrayList<>();
        data.add(routeID + "");
        data.add(agencyID);
        data.add(routeShortName);
        data.add(routeLongName);
        data.add(routeDesc);
        data.add(routeType + "");
        data.add(routeURL);
        data.add(routeColor);
        data.add(routeTextColor);

        return data;

    }

    /**
     *
     *
     * @author Andrew Budreck
     */
    public void edit(String valueOf, String newValue)
    {
        if(routeID.equals(valueOf)){
            routeID = newValue;
        }
        else if(agencyID.equals(valueOf)){
            agencyID = newValue;
        }
        else if(routeShortName.equals(valueOf)){
            routeShortName = newValue;
        }
        else if(routeDesc.equals(valueOf)){
            routeDesc = newValue;
        }
        else if ((routeType + "").equals(valueOf)){
            routeType = Integer.parseInt(newValue);
        }
        else if (routeURL.equals(valueOf)){
            routeURL = newValue;
        }
        else if (routeColor.equals(valueOf)){
            routeColor = newValue;

        }
        else if (routeColor.equals(valueOf)){

        }
        else if (routeTextColor.equals(valueOf)){

        }

    }
    public String getRouteID() {
        return routeID;
    }

    public String toString(){
        String output = "";
        if (!routeID.isEmpty()) {
            output += routeID;
        }
        output += ",";

        if (!agencyID.isEmpty()) {
            output += agencyID;
        }
        output += ",";
        if (!routeShortName.isEmpty()) {
            output += routeShortName;
        }
        output += ",";
        if (!routeLongName.isEmpty()) {
            output += routeLongName;
        }
        output += ",";
        if (!routeDesc.isEmpty()) {
            output += routeDesc;
        }
        output += ",";
        output += routeDesc;
        if (!routeURL.isEmpty()) {
            output += routeURL;
        }
        output += ",";
        if (!routeColor.isEmpty()) {
            output += routeColor;
        }
        output += ",";
        if (!routeTextColor.isEmpty()) {
            output += routeTextColor;
        }
        output += ",";

        return output;

    }


}