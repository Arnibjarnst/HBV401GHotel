package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;

public class UserController {

    @FXML
    private TextField fxUsername;
    @FXML
    private TextField fxEmail;
    @FXML
    private TextField fxPassword;

    public void LogInHandler(ActionEvent actionEvent){
        String username = fxUsername.getText();
        String password = fxPassword.getText();
    }

    public void SignUpHandler(ActionEvent actionEvent){
        String username = fxUsername.getText();
        String email = fxEmail.getText();
        String password = fxPassword.getText();
    }
}
