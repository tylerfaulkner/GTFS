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
	Label stopsFileName;
	@FXML
	Label tripsFileName;
	@FXML
	Label timesFileName;
	@FXML
	Label routesFileName;

	public Controller(){
		m_SearchSystem = new SearchSystem();
	}

	public void finalize() throws Throwable {

	}

	private void display(){

	}

	public void exportGTFS(){

	}

	/**
	 * 
	 *
	 */
	public void importGTFS(){

	}

	public void login(){

	}

	public void save(){

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
		stopsFileName.setText(filename);
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
		stopsFileName.setText(filename);
	}

	@FXML
	private  void openTrips(){
		m_SearchSystem.setRoutesFile(getFile());
		String path = m_SearchSystem.getRoutesFile().getPath();
		String filename = path.substring(path.lastIndexOf('\\') + 1);
		stopsFileName.setText(filename);
	}

	@FXML
	private void openFinish(){


	}

	@FXML
	private void uploadFiles(){
		m_SearchSystem.uploadFiles();
	}

	@FXML
	private void openFile(){
		openPane.setVisible(true);
	}

	private File getFile(){
		FileChooser output = new FileChooser();
		output.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text file", "*.txt"));
		File file = output.showOpenDialog(stage);
		return file;
	}
}