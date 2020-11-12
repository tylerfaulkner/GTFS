package tests;

import gtfs.DataGTFS;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class DataGTFSTest {


    @org.junit.jupiter.api.Test
    void setRoutes() {
        DataGTFS data = new DataGTFS();
        File good = new File(getClass().getResource("routes_good.txt").getPath());
        try {
            data.setRoutes(good);
            assertTrue(data.getRoutesCount() > 0);
        } catch (FileNotFoundException e) {
            fail();
        }
        File bad = new File(getClass().getResource("routes_no_header.txt").getPath());
        try {
            data.setRoutes(bad);
            fail();
        } catch (IllegalArgumentException e){
            assertTrue(data.getTimeCount() == 0);
        } catch (FileNotFoundException e) {
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void setStops() {
        DataGTFS data = new DataGTFS();
        File good = new File(getClass().getResource("stops_good.txt").getPath());
        try {
            data.setStops(good);
            assertTrue(data.getStopCount() > 0);
        } catch (FileNotFoundException e) {
            fail();
        }
        File bad = new File(getClass().getResource("stops_no_header.txt").getPath());
        try {
            data.setStops(bad);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(data.getStopCount() == 0);
        } catch (FileNotFoundException e){
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void setStopTime() {
        DataGTFS data = new DataGTFS();
        File good = new File(getClass().getResource("stop_times_good.txt").getPath());
        try {
            data.setStopTime(good);
            assertTrue(data.getTimeCount() > 0);
        } catch (FileNotFoundException e) {
            fail();
        }
        File bad = new File(getClass().getResource("stop_times_no_header.txt").getPath());
        try {
            data.setStopTime(bad);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(data.getTimeCount() == 0);
        } catch (FileNotFoundException e){
            fail();
        }
    }

    @org.junit.jupiter.api.Test
    void setTrips() {
        DataGTFS data = new DataGTFS();
        File good = new File(getClass().getResource("trips_good.txt").getPath());
        try {
            data.setTrips(good);
            assertTrue(data.getTripsCount() > 0);
        } catch (FileNotFoundException e) {
            fail();
        }
        File bad = new File(getClass().getResource("trips_no_header.txt").getPath());
        try {
            data.setTrips(bad);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(data.getTripsCount() == 0);
        } catch (FileNotFoundException e){
            fail();
        }
    }
}