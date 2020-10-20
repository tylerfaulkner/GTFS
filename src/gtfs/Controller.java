/*
 * Course: SE2030 - 021
 * Fall 2020
 * Lab 5 - Classes And Git
 * Author: Tyler Faulkner, Andrew Budreck
 * Created: 10/08/2020
 */
package gtfs;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * controls user input within the gui
 *
 * @author Andrew Budreck
 * @version 1.0
 */
public class Controller {

    private boolean vaildAccount;
    private SearchSystem searchSystem;
    private Stage stage;

    @FXML
    private Pane openPane;

    @FXML
    private Pane snapshotPane;

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
        snapshotPane.setVisible(true);
        snapshotPane.setDisable(false);
        openPane.setVisible(false);
        openPane.setDisable(true);
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
        removeText();
        snapshotPane.setVisible(false);
        snapshotPane.setDisable(true);
        openPane.setDisable(false);
        openPane.setVisible(true);
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
}