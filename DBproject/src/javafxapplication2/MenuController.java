package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MenuController {

    Calendar c = Calendar.getInstance();
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane main;

    @FXML
    private ImageView logOutB;

    @FXML
    private Label accountL;

    @FXML
    private Button outputB;

    @FXML
    private Button searchB;

    @FXML
    private Button calcB;

    @FXML
    private Button sortB;

    @FXML
    private Button filterB;

    @FXML
    private Button triggerB;

    @FXML
    void initialize() {

        accountL.setText(FXMLDocumentController.us);
        if(FXMLDocumentController.kk==3){
            searchB.setVisible(false);
            calcB.setVisible(false);
            filterB.setVisible(false);
            sortB.setVisible(false);
            triggerB.setVisible(false);
        }

        logOutB.setOnMouseClicked(event -> {
            logOutB.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/FXMLDocument.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        outputB.setOnMouseClicked(event -> {
            outputB.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/profile.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        searchB.setOnMouseClicked(event -> {
            searchB.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/search.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        calcB.setOnMouseClicked(event -> {
            calcB.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/calculated.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

        filterB.setOnMouseClicked(event -> {
            filterB.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/filter.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        sortB.setOnMouseClicked(event -> {
            sortB.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/sorting.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });
        triggerB.setOnMouseClicked(event -> {
            triggerB.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXML/trigger.fxml"));

            try {
                loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }

}
