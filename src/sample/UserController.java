package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
            Stage stage = (Stage) fxPassword.getScene().getWindow();
            stage.close();
        }
        else{
            fxLabel.setText("Incorrect username or password");
            fxUsername.setStyle("-fx-border-color: #FF0000;");
            fxPassword.setStyle("-fx-border-color: #FF0000;");
        }
    }

    public void SignUpHandler(ActionEvent actionEvent){
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

        String result = db.insertUser(username,email,password);
        String text = "";
        if(result.charAt(0) == '-') text = "unknown error";
        else if(result.charAt(0)  == '0'){
            MainController.userName = username;
            Stage stage = (Stage) fxEmail.getScene().getWindow();
            stage.close();
        }

        for(int i = 1; i<result.length(); i++){
            if(result.charAt(i) == 'u'){
                text += "Username taken \n";
                fxUsername.setStyle("-fx-border-color: #FF0000;");
            }
            if(result.charAt(i) == 'e'){
                text += "Email taken \n";
                fxEmail.setStyle("-fx-border-color: #FF0000;");
            }
            if(result.charAt(i) == 'p'){
                text += "Password taken";
                fxPassword.setStyle("-fx-border-color: #FF0000;");
            }
        }
        fxLabel.setText(text);
    }
}
