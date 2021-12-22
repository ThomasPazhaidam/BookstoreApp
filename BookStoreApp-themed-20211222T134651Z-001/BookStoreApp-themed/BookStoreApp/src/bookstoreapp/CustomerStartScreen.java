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
public class CustomerStartScreen {
    
    Button buy, redeemBuy, logout;
    Label welcomeMessage;
    Scene startScreen;
    private TableView selectBook = new TableView();
    
    public void start(Stage primaryStage) {
        TableColumn book = new TableColumn("Book Name");
        TableColumn price = new TableColumn("Book Price");
        TableColumn select = new TableColumn("Select");
        
        buy = new Button("Buy");
        redeemBuy = new Button("Redeem Points and Buy");
        logout = new Button("Logout");
        
        welcomeMessage = new Label("Welcome 'customerName'. You have 'getPoints' points. Your status is 'getStatus'.");
        
        selectBook.getColumns().addAll(book, price, select);
        
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        HBox bottomRow = new HBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        bottomRow.getChildren().addAll(buy, redeemBuy, logout);
        layout.getChildren().addAll(welcomeMessage, selectBook, bottomRow);
        
        startScreen = new Scene(layout, 550, 300);
        
        CustomerCostScreen bought = new CustomerCostScreen();
        book.setMinWidth(300);
        price.setMinWidth(125);
        select.setMinWidth(100);
        book.setStyle("-fx-background-color:  #222831;");
        price.setStyle("-fx-background-color:  #222831;");
        select.setStyle("-fx-background-color:  #222831;");
        startScreen.getStylesheets().add("customer.css");
        
        buy.setOnAction(e -> {
            bought.start(primaryStage);
        });
        
        redeemBuy.setOnAction(e -> {
            bought.start(primaryStage);
        });
        
        logout.setOnAction(e -> {
           LoginScreen loggedOut = new LoginScreen();
           loggedOut.start(primaryStage);
        });
        
        primaryStage.setTitle("Booksmith");
        primaryStage.setScene(startScreen);
        primaryStage.show();
    }
}
