package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animations.Shake;

import java.io.IOException;
import java.sql.SQLException;



public class regController{

    @FXML
    private TextField loginReg;//логин при регистрации

    @FXML
    private TextField emailReg;//электронная почта при регистрации

    @FXML
    private PasswordField firstPass;//первый введённый пароль

    @FXML
    private PasswordField secondPass;//второй введенный пароль

    @FXML
    private Button registerBut;//кнопка регистрации

    @FXML
    void initialize(){

        registerBut.setOnAction(event -> {
           signUpNewUser();
           goNewWindow("/sample/uipack/app.fxml");

        });
    }

    private void goNewWindow(String stage) {
        registerBut.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(stage));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage st = new Stage();
        st.setScene(new Scene(root));
        st.showAndWait();
    }

    private void signUpNewUser() {
        DataBaseHandler dbHandler = new DataBaseHandler();
        String login = loginReg.getText();
        String email = emailReg.getText();
        if(firstPass.getText().equals(secondPass.getText())){
            String password = firstPass.getText();
            System.out.println("Success!");
            User user = new User(login, password, email);
            try {
                dbHandler.regUser(user);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            Shake wrongPass1 = new Shake(firstPass);
            Shake wrongPass2 = new Shake(secondPass);
            wrongPass1.playAnim();
            wrongPass2.playAnim();
            System.out.println("Unsucces!");
        }
    }
}

