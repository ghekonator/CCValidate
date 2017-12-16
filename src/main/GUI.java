package main;

import java.awt.Color;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.Window;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Card Utility");
        primaryStage.setResizable(false);
        BorderPane test = new BorderPane();
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        // Create the registration form grid pane
        GridPane gridPane = createCardForm();
        // Add UI controls to the registration form grid pane
        addUIControls(gridPane);
        // Create a scene with registration form grid pane as the root node
        Scene scene = new Scene(test, 800, 500);
        
        MenuBar menuBar = new MenuBar();
        
        Menu menu = new Menu("Tool");
        MenuItem checker = new MenuItem("Credit Card Checker");
        menu.getItems().add(checker);
        MenuItem generator = new MenuItem("Credit Card Generator");
        menu.getItems().add(generator);
        menu.getItems().add(new SeparatorMenuItem());
        menu.getItems().add(new MenuItem("Exit"));
        
        Menu helpMenu = new Menu("Help");
        
        Menu aboutMenu = new Menu("About");
        
        generator.setOnAction(actionEvent -> System.out.println("CLciked"));	
        
        menuBar.getMenus().addAll(menu , helpMenu,aboutMenu);
        menuBar.setPrefHeight(26);
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
        
        test.setTop(menuBar);
      
        test.setCenter(gridPane);
        // Set the scene in primary stage	
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }


    private GridPane createCardForm() {
        // Instantiate a new Grid Pane
        GridPane gridPane = new GridPane();

        // Position the pane at the center of the screen, both vertically and horizontally
        gridPane.setAlignment(Pos.CENTER);

        // Set a padding of 20px on each side
        gridPane.setPadding(new Insets(40, 40, 40, 40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);

        // Add Column Constraints

        // columnOneConstraints will be applied to all the nodes placed in column one.
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);

        // columnTwoConstraints will be applied to all the nodes placed in column two.
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        return gridPane;
    }

    private void addUIControls(GridPane gridPane) {
    	
        // Add Header
        Label headerLabel = new Label("Card Utility Software");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.LEFT);
        GridPane.setMargin(headerLabel, new Insets(-90, 0,0,0));

        // Add Name Label
        Label cardNumLabel = new Label("Card Number : ");
        gridPane.add(cardNumLabel, 0,0);
        GridPane.setMargin(cardNumLabel, new Insets(0, 16,0,0));
        
        // Add Card Text Field
        TextField cardNumberField = new TextField();
        cardNumberField.setPrefHeight(40);  
        gridPane.add(cardNumberField,0, 1, 2,1);

        // Add output
        Label output = new Label();
        output.setPrefHeight(100);
        output.setPrefWidth(600);
        output.setStyle("-fx-background-color: white;-fx-border-color: black;");
        gridPane.add(output, 0, 3, 2, 1);
        GridPane.setHalignment(output, HPos.CENTER);
        GridPane.setMargin(output, new Insets(20, 0,20,0));
        output.setAlignment(Pos.TOP_LEFT);
        output.setFont(Font.font("Arial", FontWeight.BOLD, 15));
        output.setPadding(new Insets(10, 10, 10, 10));
        // Add Submit Button
        Button submitButton = new Button("Check credit card number");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(160);
        gridPane.add(submitButton, 0, 2, 2, 1);
        GridPane.setHalignment(submitButton, HPos.CENTER);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));

        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(cardNumberField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter a card number");
                    return;
                }
 
                Card test = new Card(cardNumberField.getText());
                boolean luhn = test.passesLuhn();
                boolean charCheck = test.correctFormat();
                String luhnStat = "";
                String charStat = "";
                if(luhn == true) {
                	luhnStat = "Pass";
                }
                else {
                	luhnStat = "Fail";
                }
                if(charCheck == true) {
                	charStat = "Pass";
                }
                else {
                	charStat = "Fail";
                }
           
                output.setText(" Luhn Check: "+ luhnStat+ "\n Character Check: " + charStat +  "\n"
                		+ "---------------------------------------\n Passes test: "+ test.isValid());
               
            }
        });
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}