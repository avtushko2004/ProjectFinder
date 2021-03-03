package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class appController {

    @FXML
    private Button searchProjectButton;

    @FXML
    private Button addProjectButton;

    @FXML
    void initialize(){
        searchProjectButton.setOnAction(event -> {
            goToSearch("/sample/uipack/searchandwork.fxml" );
        });
        addProjectButton.setOnAction(event -> {
            goToAdd("/sample/uipack/addproject.fxml");
        });
    }

    private void goToAdd(String window) {
        addProjectButton.getScene().getWindow().hide();
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

    private void goToSearch(String window) {
        searchProjectButton.getScene().getWindow().hide();
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
