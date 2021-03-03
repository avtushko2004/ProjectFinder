package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button logInButton;

    @FXML
    private Button registerButton;

    @FXML
    void initialize() {
        registerButton.setOnAction(event -> {
            newWindowLoader("/sample/uipack/reg.fxml");
        });
        logInButton.setOnAction(event -> {
            String loginText = loginField.getText();
            String passText = passwordField.getText();
            if(!loginText.equals("") && !passText.equals("")) {
                loginUser(loginText, passText);
            }else{
                System.out.println("Password is empty!");
            }

            newSceneLoader("/sample/uipack/app.fxml");
        });
    }

    private void loginUser(String loginText, String passText) {

    }


    public void newWindowLoader(String window) {
            registerButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(window));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        }
    public void newSceneLoader(String window) {
        logInButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }
    }

