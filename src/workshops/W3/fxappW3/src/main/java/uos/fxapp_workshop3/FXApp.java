package uos.fxapp_workshop3;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;


public class FXApp extends Application {
	Pane root = new Pane();
	Scene scene = new Scene(root,800,600);
	Label helloLabel = new Label(); 
	Label outLabel = new Label();
	TextField inTextField = new TextField();
	Label inTextFieldLabel = new Label();
	Button submitButton = new Button();
	
	EventHandler<ActionEvent> bHandler = new EventHandler<ActionEvent>() {
		@Override
		public void handle(ActionEvent event) {
			String str = inTextField.getText();
			 outLabel.setText("I am feeling " + str);
		}
	};

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setScene(scene);
		primaryStage.show();
		helloLabel.setText("Welcome to FXApp this is a demo JavaFx application");
		root.getChildren().add(helloLabel);
		
		outLabel.setText("View Result");
		outLabel.setLayoutX(10);
		outLabel.setLayoutY(100);
		root.getChildren().add(outLabel);
		
		inTextFieldLabel.setText("How are you feeling");
		root.getChildren().add(inTextFieldLabel);
		inTextFieldLabel.setLayoutX(10);
		inTextFieldLabel.setLayoutY(180);
		inTextField.setText("");
		inTextField.setLayoutX(10);
		inTextField.setLayoutY(200);
		root.getChildren().add(inTextField);
		
		submitButton.setText("Submit");
		submitButton.setLayoutX(10);
		submitButton.setLayoutY(240);
		root.getChildren().add(submitButton);
		submitButton.setOnAction(bHandler);
	}
}
