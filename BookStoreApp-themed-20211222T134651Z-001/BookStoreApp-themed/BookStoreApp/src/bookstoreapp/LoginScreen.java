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
import javafx.application.Platform;

/**
 *
 * @author Peter Cai
 */

public class LoginScreen{
    Button logIn, logOut;
    Scene login_screen;
    String adminUser, adminPass;
    
    public void start(Stage primaryStage) {
        adminUser = "admin";
        adminPass = "admin";
        
        logIn = new Button("Log In");
        logOut = new Button("Quit");
        
        GridPane login_menu = new GridPane();
        login_menu.setAlignment(Pos.CENTER);
        login_menu.setHgap(10);
        login_menu.setVgap(10);
        login_menu.setPadding(new Insets(25, 25, 25, 25));
        
        Label logInTitle = new Label("Booksmith");
        
        Text username = new Text("Username: ");
        Text password = new Text("Password: ");
        TextField usernameInput = new TextField();
        PasswordField passwordInput = new PasswordField();
        
        login_menu.add(logInTitle, 0, 0, 2, 1);
        login_menu.add(username, 0, 1);
        login_menu.add(usernameInput, 1, 1);
        login_menu.add(password, 0, 2);
        login_menu.add(passwordInput, 1, 2);
        login_menu.add(logIn, 1, 4);
        login_menu.setHalignment(logIn, HPos.RIGHT);
        login_menu.add(logOut, 2, 4);
        
        login_screen = new Scene(login_menu, 550, 300);
        logInTitle.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");
        username.setStyle("-fx-fill: #eeeeee; -fx-font-family: Helvetica, sans-serif; -fx-text-fill: #FFD369;");
        password.setStyle("-fx-fill: #eeeeee; -fx-font-family: Helvetica, sans-serif; -fx-text-fill: #FFD369;");
        usernameInput.setStyle("-fx-text-fill: #FFD369; -fx-background-color:  #393e46; -fx-font-family: Helvetica, sans-serif;");
        passwordInput.setStyle("-fx-text-fill: #FFD369; -fx-background-color:  #393e46; -fx-font-family: Helvetica, sans-serif;");
        login_screen.getStylesheets().add(this.getClass().getResource("theme.css").toExternalForm());
        logIn.setOnAction(e -> {
           if(usernameInput.getText().equals(adminUser) && passwordInput.getText().equals(adminPass)){
               OwnerStartScreen owner_start_screen = new OwnerStartScreen();
               owner_start_screen.start(primaryStage);
           }
           if(usernameInput.getText().equals("abc") && passwordInput.getText().equals("abc")){
               
               
               CustomerStartScreen customerStart = new CustomerStartScreen();
               customerStart.start(primaryStage);
           }
        });
        
        logOut.setOnAction(e -> {
            Platform.exit();
        });

        primaryStage.setTitle("Booksmith");
        primaryStage.setScene(login_screen);
        primaryStage.show();
    }  
}
