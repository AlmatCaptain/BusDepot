package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignInController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane main;

    @FXML
    private Button signBut;

    @FXML
    private TextField nameText;

    @FXML
    private TextField emailText;

    @FXML
    private PasswordField passwdText;

    @FXML
    private PasswordField keyW;

    @FXML
    private Label mess;

    @FXML
    void initialize() {
        mess.setVisible(false);
        signBut.setOnAction(event -> {

            if((nameText.getText().equals("") || emailText.getText().equals("") || passwdText.getText().equals(""))==true)
                mess.setVisible(true);
            else if((keyW.getText().equals("admin") || keyW.getText().equals("")) ==true){
                try {
                    String sqlC ="CREATE USER "+nameText.getText()+" WITH PASSWORD '"+passwdText.getText()+"'";
                    String sql="INSERT INTO users (name, email, password, role) " +
                        "VALUES ('"+nameText.getText()+"', '"+emailText.getText()+"', '"+passwdText.getText()+"', '"+keyW.getText()+"')";
                    String sql2;
                    if(keyW.getText().equals("admin")==true){
                        sql2="GRANT ALL PRIVILEGES ON ALL TABLES in schema public TO "+ nameText.getText();
                    }else
                        sql2="GRANT SELECT ON bus IN SCHEMA public TO "+ nameText.getText();

                    Statement st= JDBC.getConnection().createStatement();
                    st.execute(sql);
                    st.execute(sqlC);
                    st.execute(sql2);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                signBut.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXML/FXMLDocument.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            }else{
                mess.setText("Invalid keyword");
                mess.setVisible(true);
            }
            });
        

    }
}
