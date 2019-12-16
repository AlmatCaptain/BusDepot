package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class FXMLDocumentController {

    static String us;
    static int kk=0;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane main;

    @FXML
    private TextField email;

    @FXML
    private PasswordField userPass;

    @FXML
    private Button logIn;

    @FXML
    private Label notFind;

    @FXML
    private Hyperlink signIn;

    @FXML
    void initialize() {
        email.setFocusTraversable(false);
        userPass.setFocusTraversable(false);
        logIn.setOnAction((ActionEvent event) -> {
            if ((email.getText().equals("") || userPass.getText().equals("")) == true) {
                notFind.setText("Not all fields are filled !");
            } else {
                try {
                    String sql="select * from users";

                    Statement st= JDBC.getConnection().createStatement();
                    ResultSet rs = st.executeQuery(sql);

                    while(rs.next()){
                        String emailP=rs.getString("email");
                        String passP=rs.getString("password");
                        String keyP=rs.getString("role");

                        if ((emailP.equals(email.getText()) && passP.equals(userPass.getText()))==true) {
                            if(keyP.equals("admin")) {
                                us = new String("Admin: "+email.getText());
                                kk=0;
                                email.setText("");
                                userPass.setText("");
                                logIn.getScene().getWindow().hide();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("FXML/menu.fxml"));

                                try {
                                    loader.load();
                                } catch (IOException ex) {
                                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                Parent root = loader.getRoot();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root));
                                stage.show();
                            }else{
                                us = new String("User: "+email.getText());
                                kk=3;
                                email.setText("");
                                userPass.setText("");
                                logIn.getScene().getWindow().hide();
                                FXMLLoader loader = new FXMLLoader();
                                loader.setLocation(getClass().getResource("FXML/menu.fxml"));

                                try {
                                    loader.load();
                                } catch (IOException ex) {
                                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                Parent root = loader.getRoot();
                                Stage stage = new Stage();
                                stage.setScene(new Scene(root));
                                stage.show();
                            }
                        }
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }
        });

        signIn.setOnAction(event -> {

            signIn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/signIn.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }
}
