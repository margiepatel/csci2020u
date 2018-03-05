package sample;

//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.control.*;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class Controller {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private TextField  fullNameField;
    @FXML private TextField emailField;
    @FXML private TextField phoneField;
    @FXML private DatePicker birthdayField;



    public void register(ActionEvent e) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String fullname = fullNameField.getText();
        String email = emailField.getText();
        String phonenumber = phoneField.getText();
        LocalDate birthday = birthdayField.getValue();

        System.out.println("Register:");
        System.out.println("\tUsername:   " + username);
        System.out.println("\tPassword1:  " + password);
        System.out.println("\tFull Name: " + fullname);
        System.out.println("\tE-Mail:     " + email);
        System.out.println("\tPhone #: " + phonenumber);
        System.out.println("\tDate of Birth: " + birthday);
    }
}