package my.caculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField display = new TextField();
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNew = true;

    @Override
    public void start(Stage primaryStage) {

        display.setPrefHeight(60);
        display.setFont(Font.font(24));
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);
        display.setStyle("-fx-background-color: #1e1e1e; -fx-text-fill: white; -fx-border-color: #333;");

        GridPane buttonGrid = new GridPane();
        buttonGrid.setHgap(10);
        buttonGrid.setVgap(10);
        buttonGrid.setPadding(new Insets(10));
        buttonGrid.setAlignment(Pos.CENTER);

        String[][] buttons = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", ".", "C", "+"},
                {"=", "", "", ""}
        };

        for (int row = 0; row < buttons.length; row++) {
            for (int col = 0; col < buttons[row].length; col++) {
                String text = buttons[row][col];
                if (text.isEmpty()) continue;

                Button btn = new Button(text);
                btn.setPrefSize(80, 60);
                btn.setFont(Font.font(18));
                btn.setStyle(getButtonStyle(text));
                btn.setOnAction(e -> handleButton(text));
                buttonGrid.add(btn, col, row);
            }
        }

        VBox root = new VBox(10, display, buttonGrid);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #2b2b2b;");

        Scene scene = new Scene(root, 360, 450);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Calculator");
        primaryStage.show();
    }

    private void handleButton(String text) {
        switch (text) {
            case "C":
                display.clear();
                firstOperand = 0;
                operator = "";
                break;
            case "=":
                if (!operator.isEmpty() && display.getText().contains(operator)) {
                    String op = "\\" + operator; 
                    String[] parts = display.getText().split(" " + op + " ");
                    if (parts.length == 2) {
                        try {
                            double a = Double.parseDouble(parts[0]);
                            double b = Double.parseDouble(parts[1]);
                            double result = calculate(a, b, operator);
                            if (result == (long) result) {
                                display.setText(String.valueOf((long) result));
                            } else {
                                display.setText(String.valueOf(result));
                            }
                            operator = "";
                        } catch (NumberFormatException e) {
                            display.setText("Error");
                        }
                    }
                }
                break;
            case "+": case "-": case "*": case "/":
                if (!display.getText().isEmpty() && operator.isEmpty()) {
                    operator = text;
                    display.appendText(" " + operator + " ");
                }
                break;
            default: 
                display.appendText(text);
        }
    }

    private double parseDisplay() {
        try {
            return Double.parseDouble(display.getText());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private double calculate(double a, double b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return b != 0 ? a / b : 0;
            default: return 0;
        }
    }

    private String getButtonStyle(String text) {
        if ("+-*/=".contains(text)) {
            return "-fx-background-color: #ff9500; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 10;";
        } else if ("C".equals(text)) {
            return "-fx-background-color: #ff3b30; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 10;";
        } else {
            return "-fx-background-color: #505050; -fx-text-fill: white; -fx-background-radius: 10;";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

