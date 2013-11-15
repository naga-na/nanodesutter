package fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppMain extends Application {

	public static void main (String[] args) {
		//run JavaFx
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// read fxml
		Parent root = FXMLLoader.load(getClass().getResource("/nanodesu.fxml"));
		// create and set Scene
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("ーたっすでのな");
		// view
		stage.show();
	}
	
}
