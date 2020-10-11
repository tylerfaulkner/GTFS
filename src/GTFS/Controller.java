package GTFS;


import javafx.fxml.FXML;
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
	public SerchSystem m_SerchSystem;
	private Stage stage;

	@FXML
	Pane openPane = new Pane();

	@FXML
	Pane lastPane;

	public Controller(){

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

	/**
	 * 
	 * @param filter
	 */
	private void setFilter(String filter){

	}

	@FXML
	private void openRoutes(){
		m_SerchSystem.setRoutes(getFile());
	}

	@FXML
	private void openStops(){
		m_SerchSystem.setStops(getFile());
	}

	@FXML
	private void openStopTimes(){
		m_SerchSystem.setStopTime(getFile());
	}

	@FXML
	private  void openTrips(){
		m_SerchSystem.setTrips(getFile());
	}

	@FXML
	private void openFinish(){


	}

	@FXML
	private void openFile(){
		openPane.setVisible(true);
	}

	private File getFile(){
		FileChooser output = new FileChooser();
		output.getExtensionFilters().add(new FileChooser.ExtensionFilter(".txt"));
		return output.showOpenDialog(stage);

	}
}