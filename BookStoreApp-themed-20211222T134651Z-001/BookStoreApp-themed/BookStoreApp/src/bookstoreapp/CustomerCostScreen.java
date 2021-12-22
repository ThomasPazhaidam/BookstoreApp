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
public class CustomerCostScreen {
    
    Button logout;
    Label totalCost, pointsAndStatus;
    Scene costScreen;
    
    public void start(Stage primaryStage) {
        
        logout = new Button("Logout");
        
        totalCost = new Label("Total Cost: $___");
        pointsAndStatus = new Label("Points: P, Status: S");
        
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10, 10, 10, 10));
        
        root.getChildren().addAll(totalCost, pointsAndStatus, logout);
        
        costScreen = new Scene(root, 550, 300);
        costScreen.getStylesheets().add("cost.css");
        
        logout.setOnAction(e -> {
           LoginScreen loggedOut = new LoginScreen();
           loggedOut.start(primaryStage);
        });
        
        primaryStage.setTitle("Booksmith");
        primaryStage.setScene(costScreen);
        primaryStage.show();
    }
}
