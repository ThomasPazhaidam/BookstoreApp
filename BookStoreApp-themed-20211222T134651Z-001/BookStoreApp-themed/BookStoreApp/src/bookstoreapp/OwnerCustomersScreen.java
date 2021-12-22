/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstoreapp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;

/**
 *
 * @author Peter Cai
 */
public class OwnerCustomersScreen {
    
    Button add, delete, back;
    TextField usernameInput, passwordInput;
    Scene customerScreen;
    private TableView allCustomers = new TableView();
    
    public void start(Stage primaryStage) {
        TableColumn username = new TableColumn("Username");
        TableColumn password = new TableColumn("Password");
        TableColumn points = new TableColumn("Points");
        
        allCustomers.getColumns().addAll(username, password, points);
        
        add = new Button("Add");
        delete = new Button("Delete");
        back = new Button("Back");
        
        usernameInput = new TextField();
        passwordInput = new TextField();
        usernameInput.setPromptText("Username:");
        passwordInput.setPromptText("Password:");
        
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        GridPane interactions = new GridPane();
        interactions.setHgap(10);
        interactions.setVgap(10);
        interactions.setPadding(new Insets(10, 10, 10, 10));
        
        interactions.add(usernameInput, 0, 0);
        interactions.add(passwordInput, 1, 0);
        interactions.add(add, 2, 0);
        interactions.add(delete, 0, 1);
        interactions.add(back, 1, 1);
        
        layout.getChildren().addAll(allCustomers, interactions);
        
        customerScreen = new Scene(layout, 550, 300);
        username.setMinWidth(200);
        password.setMinWidth(200);
        points.setMinWidth(125);
        username.setStyle("-fx-background-color:  #222831;");
        password.setStyle("-fx-background-color:  #222831;");
        points.setStyle("-fx-background-color:  #222831;");
        usernameInput.setStyle("-fx-background-color:  #eeeeee; -fx-font-family: Helvetica, sans-serif; -fx-text-fill: #393e46; -fx-prompt-text-fill: #393e46;");
        passwordInput.setStyle("-fx-background-color:  #eeeeee; -fx-font-family: Helvetica, sans-serif; -fx-text-fill: #393e46; -fx-prompt-text-fill: #393e46;");
        customerScreen.getStylesheets().add(this.getClass().getResource("owner.css").toExternalForm());
        
        add.setOnAction(e -> {
            Customer newUser = new Customer(usernameInput.getText(), passwordInput.getText());
            
        });
        
        delete.setOnAction(e -> {
            
        });
        
        back.setOnAction(e -> {
           OwnerStartScreen startScreen = new OwnerStartScreen();
           startScreen.start(primaryStage);
        });
        
        primaryStage.setTitle("Booksmith");
        primaryStage.setScene(customerScreen);
        primaryStage.show();
    }
}
