package sujon.commandpatternappworkshop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class CommandPatternApp {
	
	Pane root;
	Scene scene;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	primaryStage.setTitle("Command Pattern Drawing App");
	root = new Pane();
	scene = new Scene(root, 600, 400);
	primaryStage.setScene(scene);
	primaryStage.show();
	}
}
