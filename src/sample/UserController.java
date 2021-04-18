package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UserController {

    UserDB db;

    @FXML
    private TextField fxUsername;
    @FXML
    private TextField fxEmail;
    @FXML
    private TextField fxPassword;
    @FXML
    private Label fxLabel;

    public UserController(){
        db = new UserDB();
    }

    public void LogInHandler(ActionEvent actionEvent){
        String username = fxUsername.getText();
        String password = fxPassword.getText();
        boolean loggedIn = db.logInUser(username,password);
    }

    public void SignUpHandler(ActionEvent actionEvent){
        String username = fxUsername.getText();
        String email = fxEmail.getText();
        String password = fxPassword.getText();
        int result = db.insertUser(username,email,password);
        String text = "";
        if(result == -1) text = "unknown error";
        else if(result == 0) text = "Successful Sign Up";
        else if(result == 1) text = "Password taken";
        else if(result == 2) text = "Email taken";
        else text = "Password and Email taken";
        fxLabel.setText(text);
    }
}
