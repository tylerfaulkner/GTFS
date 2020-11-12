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


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * controls user input within the gui
 *
 * @author Andrew Budreck
 * @version 1.0
 */
public class Controller {

    private boolean stopGridFirstOpen = true;

    private boolean vaildAccount;
    private SearchSystem searchSystem;
    private Stage stage;

    @FXML
    private TextField editInput;

    @FXML
    private Pane editPane;

    @FXML
    private ChoiceBox editChoices;

    @FXML
    private Pane openPane;

    @FXML
    private Pane snapshotPane;

    @FXML
    private Pane stopPane;

    @FXML
    private Pane tripPane;

    @FXML
    private ListView editView;

    @FXML
    private TextField stopId = new TextField();

    @FXML
    private ListView findByStopId;

    @FXML
    Pane findWithStopId = new Pane();

    @FXML
    private Label stopsFileName;
    @FXML
    private Label tripsFileName;
    @FXML
    private Label timesFileName;
    @FXML
    private Label routesFileName;

    @FXML
    private Label stopCount;
    @FXML
    private Label timesCount;
    @FXML
    private Label tripsCount;
    @FXML
    private Label routesCount;
    @FXML
    private Pane savePane;
    @FXML
    private GridPane stopGrid;
    @FXML
    private GridPane tripsGrid;

    private int editType;
    private Pane currentPane = new Pane();


    /**
     * runs code to create new search system object
     *
     * @author Tyler Faulkner
     */
    public Controller() {
        searchSystem = new SearchSystem();
    }


    /**
     * not finished
     *
     * @author tbd
     */
    private void display() {

    }

    /**
     * not finished
     *
     * @author tbd
     */
    public void exportGTFS() {

    }

    /**
     * not finished
     *
     * @author tbd
     */
    public void login() {

    }

    /**
     * not finished
     *
     * @author tbd
     */
    public void save() {

    }

    /**
     * sets labels to display a snapshot of the data to show to the user
     *
     * @author Tyler Faulkner
     */
    private void setSnapshot() {
        tripsCount.setText(Integer.toString(searchSystem.dataGTFS.getTripsCount()));
        stopCount.setText(Integer.toString(searchSystem.dataGTFS.getStopCount()));
        routesCount.setText(Integer.toString(searchSystem.dataGTFS.getRoutesCount()));
        timesCount.setText(Integer.toString(searchSystem.dataGTFS.getTimeCount()));
    }

    /**
     * sets the labels of file names to be blank
     *
     * @author Tyler Faulkner
     */
    private void removeText() {
        routesFileName.setText("");
        tripsFileName.setText("");
        stopsFileName.setText("");
        timesFileName.setText("");
    }


    /**
     * sets the labels of file names to be blank
     *
     * @author Tyler Faulkner
     */
    private void setStopGrid() {
        List<Stop> stops = searchSystem.getStopsList();
        int rowNum = 1;
        for (Stop stop : stops) {
            Label stop_id = new Label();
            stop_id.setText(Integer.toString(stop.getStopID()));
            stopGrid.addRow(rowNum, stop_id);
            Label trips = new Label();
            trips.setText(Integer.toString(searchSystem.getTotalTripOfStop(stop.getStopID())));
            stopGrid.add(trips, 1, rowNum);
            rowNum++;
        }
    }

    private void setTripGrid() {
        List<Trip> trips = searchSystem.getTripsList();
        int rowNum = 1;
        for (Trip trip : trips) {
            System.out.println(rowNum);
            Label trip_id = new Label();
            trip_id.setText(trip.getTripID());
            tripsGrid.addRow(rowNum, trip_id);
            Label distance = new Label();
            try {
                distance.setText(String.format("%.2f miles", searchSystem.getDistanceTrip(trip.getTripID())));
            } catch (NullPointerException e) {

            }
            tripsGrid.add(distance, 1, rowNum);
            rowNum++;
        }
    }

    /**
     * runs code to create new search system object
     *
     * @param stage used for a basis for file opener
     * @author Tyler Faulkner
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * to be made
     *
     * @param filter
     */
    private void setFilter(String filter) {

    }

    /**
     * gets the route file from the user to import to data file
     *
     * @author Andrew Budreck
     */
    @FXML
    private void openRoutes() {
        searchSystem.setRoutesFile(getFile());
        String path = searchSystem.getRoutesFile().getPath();
        String filename = path.substring(path.lastIndexOf('\\') + 1);
        routesFileName.setText(filename);
    }

    /**
     * gets the stops file from the user to import to data file
     *
     * @author Andrew Budreck
     */
    @FXML
    private void openStops() {
        searchSystem.setStopFile(getFile());
        String path = searchSystem.getStopFile().getPath();
        String filename = path.substring(path.lastIndexOf('\\') + 1);
        stopsFileName.setText(filename);
    }

    /**
     * gets the stop times file from the user to import to data file
     *
     * @author Andrew Budreck
     */
    @FXML
    private void openStopTimes() {
        searchSystem.setTimesFile(getFile());
        String path = searchSystem.getTimesFile().getPath();
        String filename = path.substring(path.lastIndexOf('\\') + 1);
        timesFileName.setText(filename);
    }

    /**
     * gets the trip files from the user to import to data file
     *
     * @author Andrew Budreck
     */
    @FXML
    private void openTrips() {
        searchSystem.setTripsFile(getFile());
        String path = searchSystem.getTripsFile().getPath();
        String filename = path.substring(path.lastIndexOf('\\') + 1);
        tripsFileName.setText(filename);
    }

    /**
     * not finished
     *
     * @author tbd
     */
    @FXML
    private void openFinish() {
        currentPane.setVisible(false);
        currentPane.setDisable(true);
        snapshotPane.setVisible(true);
        snapshotPane.setDisable(false);
        currentPane = snapshotPane;
        uploadFiles();
    }

    /**
     * to be finished
     *
     * @author tbd
     */
    @FXML
    private void uploadFiles() {
        searchSystem.uploadFiles();
        setSnapshot();
    }

    /**
     * controls user input within the gui
     *
     * @author Andrew Budreck
     * @version 1.0
     */
    @FXML
    private void openFile() {
        currentPane.setVisible(false);
        currentPane.setDisable(true);
        openPane.setDisable(false);
        openPane.setVisible(true);
        currentPane = openPane;
    }

    /**
     * takes you home paige
     *
     * @author Tyler Faulkner
     */
    @FXML
    public void goHome() {
        currentPane.setVisible(false);
        currentPane.setDisable(true);
        snapshotPane.setDisable(false);
        snapshotPane.setVisible(true);
        currentPane = snapshotPane;
    }

    /**
     * props the user with a file opener and get a file from user
     *
     * @return a file chosen from the user
     * @author Andrew Budreck
     */
    private File getFile() {
        FileChooser output = new FileChooser();
        output.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file", "*.txt"));
        File file = output.showOpenDialog(stage);
        return file;
    }

    /**
     * sets up to save a new file
     *
     * @author Andrew Budreck
     */
    @FXML
    private void exportRoutes() {
        try {
            searchSystem.dataGTFS.exportRoutes(getSaveFile());
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Could Not Load File");
            alert.setContentText("The file could not be saved");
            alert.showAndWait();
        }

    }

    /**
     * sets up to save a new file
     *
     * @author Andrew Budreck
     */
    @FXML
    private void exportStops() {
        try {
            searchSystem.dataGTFS.exportStops(getSaveFile());
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Could Not Load File");
            alert.setContentText("The file could not be saved");
            alert.showAndWait();
        }
    }

    /**
     * sets up to save a new file
     *
     * @author Andrew Budreck
     */
    @FXML
    private void exportStopTimes() {
        try {
            searchSystem.dataGTFS.exportStopTimes(getSaveFile());
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Could Not Load File");
            alert.setContentText("The file could not be saved");
            alert.showAndWait();
        }
    }

    /**
     * sets up to save a new file
     *
     * @author Andrew Budreck
     */
    @FXML
    private void exportTrips() {
        try {
            searchSystem.dataGTFS.exportTrips(getSaveFile());
        } catch (FileNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Could Not Load File");
            alert.setContentText("The file could not be saved");
            alert.showAndWait();
        }
    }

    /**
     * sets up to save a new file
     *
     * @author Andrew Budreck
     */
    private File getSaveFile() {
        FileChooser output = new FileChooser();
        output.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file", "*.txt"));
        File file = output.showSaveDialog(stage);
        return file;
    }

    /**
     * opens save pane
     *
     * @author Andrew Budreck
     */
    @FXML
    private void saveFiles() {
        savePane.setVisible(true);
        currentPane.setVisible(false);
        currentPane = savePane;
    }

    @FXML
    private void stopFindRoutes() {
        if (searchSystem.getTimesFile() != null && searchSystem.getTripsFile() != null) {
            ArrayList<String> routeId = searchSystem.searchRoutesWithStopID(Integer.parseInt(stopId.getText()));
            findByStopId.getItems().clear();
            findByStopId.getItems().addAll(routeId);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Both a stop_times file and a trips file are needed to find all trips a stop is found on.");
            alert.setHeaderText("Missing Files");
            alert.showAndWait();
        }
    }

    /**
     * finds the closest stop
     *
     * @author Andrew Budreck
     */
    @FXML
    private void stopFindClosestStop() {
        ArrayList<String> routeId = searchSystem.searchClosestTimeWithStopID(new Integer(stopId.getText()));
        findByStopId.getItems().clear();
        findByStopId.getItems().addAll(routeId);
    }

    /**
     * Finds stops for routes
     *
     * @author Andrew Budreck
     */
    @FXML
    public void findStopsForRoute(ActionEvent actionEvent) {
        findWithStopId.setVisible(true);
        findWithStopId.setDisable(false);
        currentPane.setVisible(false);
        currentPane.setDisable(true);
        currentPane = findWithStopId;
    }

    /**
     * displays stops
     *
     * @author Tyler
     */
    @FXML
    private void viewStops() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Building table of Stops...");
        if (searchSystem.getStopFile() != null) {
            alert.setHeaderText("Building. Please wait.");
            alert.show();
            setStopGrid();
        }
        currentPane.setVisible(false);
        currentPane.setDisable(false);
        stopPane.setVisible(true);
        stopPane.setDisable(false);
        currentPane = stopPane;
        alert.close();
    }

    @FXML
    private void viewTrips() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Building table of Trips...");
        if (searchSystem.getTripsFile() != null && searchSystem.getTimesFile() != null && searchSystem.getStopFile() != null) {
            alert.setHeaderText("Building. Please wait.");
            alert.show();
            setTripGrid();
        }
        currentPane.setVisible(false);
        currentPane.setDisable(false);
        tripPane.setVisible(true);
        tripPane.setDisable(false);
        currentPane = tripPane;
        alert.close();
    }

    /**
     * @author Andrew Budreck
     */
    @FXML
    public void editData() {
        editPane.setVisible(true);
        currentPane.setVisible(false);
        currentPane = editPane;
    }

    /**
     * @author Andrew Budreck
     */
    @FXML
    public void getRoutes() {
        editChoices.getItems().clear();
        editView.getItems().clear();
        editView.getItems().addAll(searchSystem.dataGTFS.getAllRoutes());
        editType = 1;
    }

    /**
     * @author Andrew Budreck
     */
    @FXML
    public void getStops() {
        editChoices.getItems().clear();
        editView.getItems().clear();
        editView.getItems().addAll(searchSystem.dataGTFS.getAllStops());
        editType = 0;
    }

    /**
     * @author Andrew Budreck
     */
    @FXML
    public void getTrips() {
        editChoices.getItems().clear();
        editView.getItems().clear();
        editView.getItems().addAll(searchSystem.dataGTFS.getAllTrips());
        editType = 2;
    }

    /**
     * @author Andrew Budreck
     */
    @FXML
    public void getStopTimes() {
        editChoices.getItems().clear();
        editView.getItems().clear();
        editView.getItems().addAll(searchSystem.dataGTFS.getAllTrips());
        editType = 3;
    }

    /**
     * @author Andrew Budreck
     */
    @FXML
    public void editValues() {

        editChoices.getItems().clear();
        int editValue = editView.getSelectionModel().getSelectedIndex();
        if (editType == 0) {
            editChoices.getItems().add("stop_id,stop_name,stop_desc,stop_lat,stop_lon");
            editChoices.getItems().addAll(searchSystem.dataGTFS.getStopValue(editValue).getData());
        } else if (editType == 1) {
            editChoices.getItems().add("route_id,agency_id,route_short_name,route_long_name,route_desc,route_type,route_url,route_color,route_text_color");
            editChoices.getItems().addAll(searchSystem.dataGTFS.getRouteValue(editValue).getData());
        } else if (editType == 2) {
            editChoices.getItems().add("route_id,service_id,trip_id,trip_headsign,direction_id,block_id,shape_id");
            editChoices.getItems().addAll(searchSystem.dataGTFS.getTripValue(editValue).getData());
        } else if (editValue == 3) {
            editChoices.getItems().add("trip_id,arrival_time,departure_time,stop_id,stop_sequence,stop_headsign,pickup_type,drop_off_type");
            editChoices.getItems().addAll(searchSystem.dataGTFS.getStopTimeValue(editValue).getData());
        }

    }

    /**
     * @author Andrew Budreck
     */
    @FXML
    public void finishEdit() {
        int editValue = editView.getSelectionModel().getSelectedIndex();
        String editOf = editChoices.getSelectionModel().getSelectedItem().toString();

        if (editType == 0) {
            searchSystem.dataGTFS.getStopValue(editValue).edit(editOf, editInput.getText());
        } else if (editType == 1) {
            searchSystem.dataGTFS.getRouteValue(editValue).edit(editOf, editInput.getText());
        } else if (editType == 2) {
            searchSystem.dataGTFS.getTripValue(editValue).edit(editOf, editInput.getText());
        } else if (editType == 3) {
            searchSystem.dataGTFS.getStopTimeValue(editValue).edit(editOf, editInput.getText());
        }


    }

}