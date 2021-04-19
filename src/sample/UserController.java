package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        fxUsername.setStyle("");
        fxPassword.setStyle("");

        String username = fxUsername.getText();
        String password = fxPassword.getText();
        boolean loggedIn = db.logInUser(username,password);
        if(loggedIn){
            MainController.userName = username;
            fxLabel.setText("Log in successful");
        }
        else{
            fxLabel.setText("Incorrect username or password");
            fxUsername.setStyle("-fx-border-color: #FF0000;");
            fxPassword.setStyle("-fx-border-color: #FF0000;");
        }
    }

    public void SignUpHandler(ActionEvent actionEvent){
        System.out.println(fxUsername.getStyle());
        fxLabel.setText("");
        fxUsername.setStyle("");
        fxEmail.setStyle("");
        fxPassword.setStyle("");

        String username = fxUsername.getText();
        String email = fxEmail.getText();
        String password = fxPassword.getText();

        String labelString = "";
        if(username.length() < 3){
            labelString += "Username must be at least 3 letters \n";
            fxUsername.setStyle("-fx-border-color: #FF0000;");
        }
        Matcher match = Pattern.compile("^[A-Z0-9.%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email);
        if(!match.find()){
            labelString += "Illegal email \n";
            fxEmail.setStyle("-fx-border-color: #FF0000;");
        }
        if(password.length() < 8){
            labelString += "Password must be at least 8 letters \n";
            fxPassword.setStyle("-fx-border-color: #FF0000;");
        }
        if(labelString.length() > 0){
            fxLabel.setText(labelString);
            return;
        }

        System.out.println(fxPassword.getStyle());

        int result = db.insertUser(username,email,password);
        String text = "";
        if(result == -1) text = "unknown error";
        else if(result == 0){
            text = "Successful Sign Up";
        }
        else if(result == 1){
            text = "Password taken";
            fxPassword.setStyle("-fx-border-color: #FF0000;");
        }
        else if(result == 2){
            text = "Email taken";
            fxEmail.setStyle("-fx-border-color: #FF0000;");
        }
        else{
            text = "Password and Email taken";
            fxPassword.setStyle("-fx-border-color: #FF0000;");
            fxEmail.setStyle("-fx-border-color: #FF0000;");
        }
        fxLabel.setText(text);
    }
}
