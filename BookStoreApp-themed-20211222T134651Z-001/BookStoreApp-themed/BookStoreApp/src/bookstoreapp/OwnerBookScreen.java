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
public class OwnerBookScreen {
    
    Button add, delete, back;
    TextField name, price;
    Scene bookScreen;
    private TableView allBooks = new TableView();
    
    public void start(Stage primaryStage) {
        
        TableColumn bookName = new TableColumn("Book Name");
        TableColumn bookPrice = new TableColumn("Book Price");
        
        add = new Button("Add");
        delete = new Button("Delete");
        back = new Button("Back");
        
        name = new TextField();
        price = new TextField();
        name.setPromptText("Name of Book:");
        price.setPromptText("Price of Book: $");
        
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        
        GridPane middle = new GridPane();
        middle.setHgap(10);
        middle.setVgap(10);
        middle.setPadding(new Insets(10, 10 , 10, 10));
        
        middle.add(name, 0, 0);
        middle.add(price, 1, 0);
        middle.add(add, 2, 0);
        middle.add(delete, 0, 1);
        middle.add(back, 1, 1);
        
        allBooks.getColumns().addAll(bookName, bookPrice);
       
        layout.getChildren().addAll(allBooks, middle);
        
        bookScreen = new Scene(layout, 550, 300);
        bookScreen.getStylesheets().add(this.getClass().getResource("owner.css").toExternalForm()); 
        bookName.setStyle("-fx-background-color:  #222831;");
        bookPrice.setStyle("-fx-background-color:  #222831;");
        bookName.setMinWidth(350);
        bookPrice.setMinWidth(175);
        name.setStyle("-fx-background-color:  #eeeeee; -fx-font-family: Helvetica, sans-serif; -fx-text-fill: #393e46; -fx-prompt-text-fill: #393e46;");
        price.setStyle("-fx-background-color:  #eeeeee; -fx-font-family: Helvetica, sans-serif; -fx-text-fill: #393e46; -fx-prompt-text-fill: #393e46;");
        
        back.setOnAction(e -> {
           OwnerStartScreen startScreen = new OwnerStartScreen();
           startScreen.start(primaryStage);
        });
             
        primaryStage.setTitle("Booksmith");
        primaryStage.setScene(bookScreen);
        primaryStage.show();
    }   
}
