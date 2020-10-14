package GTFS;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * @author budrecka
 * @version 1.0
 * @created 08-Oct-2020 9:36:59 AM
 */
public class Controller {

	private boolean vaildAccount;
	public SearchSystem m_SearchSystem;
	private Stage stage;

	@FXML
	Pane openPane = new Pane();

	@FXML
	Pane lastPane;
	@FXML
	Pane snapshotPane;

	@FXML
	Label stopsFileName;
	@FXML
	Label tripsFileName;
	@FXML
	Label timesFileName;
	@FXML
	Label routesFileName;

	@FXML
	Label stopCount;
	@FXML
	Label timesCount;
	@FXML
	Label tripsCount;
	@FXML
	Label routesCount;

	public Controller(){
		m_SearchSystem = new SearchSystem();
	}


	private void display(){

	}

	public void exportGTFS(){

	}

	public void login(){

	}

	public void save(){

	}

	private void setSnapshot(){
		tripsCount.setText(String.valueOf(m_SearchSystem.m_DataGTFS.getTripsCount()));
		stopCount.setText(String.valueOf(m_SearchSystem.m_DataGTFS.getStopCount()));
		routesCount.setText(String.valueOf(m_SearchSystem.m_DataGTFS.getRoutesCount()));
		timesCount.setText(String.valueOf(m_SearchSystem.m_DataGTFS.getTimeCount()));
	}

	public void setStage(Stage stage){
		this.stage = stage;
	}

	/**
	 * 
	 * @param filter
	 */
	private void setFilter(String filter){

	}

	@FXML
	private void openRoutes(){
		m_SearchSystem.setRoutesFile(getFile());
		String path = m_SearchSystem.getRoutesFile().getPath();
		String filename = path.substring(path.lastIndexOf('\\') + 1);
		routesFileName.setText(filename);
	}

	@FXML
	private void openStops(){
		m_SearchSystem.setStopFile(getFile());
		String path = m_SearchSystem.getStopFile().getPath();
		String filename = path.substring(path.lastIndexOf('\\') + 1);
		stopsFileName.setText(filename);
	}

	@FXML
	private void openStopTimes(){
		m_SearchSystem.setTimesFile(getFile());
		String path = m_SearchSystem.getTimesFile().getPath();
		String filename = path.substring(path.lastIndexOf('\\') + 1);
		timesFileName.setText(filename);
	}

	@FXML
	private  void openTrips(){
		m_SearchSystem.setTripsFile(getFile());
		String path = m_SearchSystem.getTripsFile().getPath();
		String filename = path.substring(path.lastIndexOf('\\') + 1);
		tripsFileName.setText(filename);
	}

	@FXML
	private void openFinish(){


	}

	@FXML
	private void uploadFiles(){
		m_SearchSystem.uploadFiles();
		setSnapshot();
		snapshotPane.setVisible(true);
		snapshotPane.setDisable(false);
		openPane.setVisible(false);
		openPane.setDisable(true);
	}

	@FXML
	private void openFile(){
		snapshotPane.setVisible(false);
		snapshotPane.setDisable(true);
		openPane.setDisable(false);
		openPane.setVisible(true);
	}

	private File getFile(){
		FileChooser output = new FileChooser();
		output.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file", "*.txt"));
		File file = output.showOpenDialog(stage);
		return file;
	}
}