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
public class OwnerStartScreen{
    Button books, customers, logOut;
    Scene ownerStartScreen;
    
    public void start(Stage primaryStage) {
        books = new Button("Books");
        customers = new Button("Customers");
        logOut = new Button("Log Out");
        
        GridPane ownerStartMenu = new GridPane();
        ownerStartMenu.setAlignment(Pos.CENTER);
        ownerStartMenu.setHgap(10);
        ownerStartMenu.setVgap(10);
        ownerStartMenu.setPadding(new Insets(25, 25, 25, 25));
        
        ownerStartMenu.add(books, 0, 1);
        ownerStartMenu.add(customers, 0, 2);
        ownerStartMenu.add(logOut, 0, 3);
        
        ownerStartScreen = new Scene(ownerStartMenu, 550, 300);
        books.setStyle("-fx-font-weight: bold; -fx-font-size: 13pt;");
        customers.setStyle("-fx-font-weight: bold; -fx-font-size: 13pt;");
        logOut.setStyle("-fx-font-weight: bold; -fx-font-size: 13pt;");
        ownerStartScreen.getStylesheets().add("theme.css");
        
        books.setOnAction(e -> {
           OwnerBookScreen bookScreen = new OwnerBookScreen();
           bookScreen.start(primaryStage);
        });
        
        customers.setOnAction(e -> {
           OwnerCustomersScreen customerScreen = new OwnerCustomersScreen();
           customerScreen.start(primaryStage);
        });
        
        logOut.setOnAction(e-> {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.start(primaryStage);
        });
        
        primaryStage.setTitle("BookSmith");
        primaryStage.setScene(ownerStartScreen);
        primaryStage.show();
    }  
}
