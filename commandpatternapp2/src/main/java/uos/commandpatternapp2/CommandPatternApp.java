package uos.commandpatternapp2;

import javafx.scene.canvas.Canvas;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class CommandPatternApp extends Application {

	Pane root;
	Scene scene;
	private GraphicsContext gc;

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

		Canvas canvas;
		canvas = new Canvas(800, 600);
		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		gc.setStroke(Color.WHITE);
		gc.setLineWidth(9);
		gc.setFill(Color.BLUE);
		gc.fillRect(0, 0, 600, 400);

		gc.strokeOval(100, 100, 400, 200);
		
		scene.setOnMouseDragged(mouseHanler);
		scene.setOnKeyPressed(keyboardHanler);
	}
	
	// This is field declaration, that's why we use ; after finish declaration like variable; 
	// This field allows use to draw on canvas 
	EventHandler<MouseEvent> mouseHanler = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			DrawCommand d = new DrawCommand (gc, event.getX(), event.getY());
			commandPattern.addCommand(d);
		}
	};
	
	// Keyboard handler field 
	EventHandler<KeyEvent> keyboardHanler = new EventHandler<KeyEvent>() {
		@Override 
		public void handle (KeyEvent event) {
			if(event.getCode() == KeyCode.R) {
				commandPattern.redo();
			}
			if(event.getCode() == KeyCode.U) {
				commandPattern.undo();
			}
		}
	};
	
	CommandPattern commandPattern = new CommandPattern();
	
}
