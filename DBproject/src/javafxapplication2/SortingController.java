package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SortingController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane main;

    @FXML
    private ImageView logOutB;

    @FXML
    private TableView<ObservableList> tableview;

    @FXML
    private ChoiceBox<String> cb;

    @FXML
    private Button showB;

    @FXML
    void initialize() {

        cb.setItems(FXCollections.observableArrayList(
                "ASC", "DESC"));
        ObservableList<ObservableList> data;
        data = FXCollections.observableArrayList();
        System.out.println(cb.getSelectionModel().getSelectedItem());

        showB.setOnMouseClicked(event -> {
            tableview.getItems().clear();
            tableview.getColumns().clear();
            data.clear();
            String query = "SELECT driver.driverid,driver.name,payment.paymentamount FROM driver " +
                    "join payment on payment.paymentid=driver.paymentid " +
                    "ORDER BY payment.paymentamount " + cb.getSelectionModel().getSelectedItem();

            String result = "";

            try (Statement stmt = JDBC.getConnection().createStatement()) {

                ResultSet resultSet = stmt.executeQuery(query);

                for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                    final int j = i;
                    TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i + 1));
                    col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
                        public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                            return new SimpleStringProperty(param.getValue().get(j).toString());
                        }
                    });

                    tableview.getColumns().addAll(col);
                    System.out.println("Column [" + i + "] ");
                }

                while (resultSet.next()) {

                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                        row.add(resultSet.getString(i));
                    }
                    System.out.println("Row [1] added " + row);
                    data.add(row);
                }
                tableview.setItems(data);

        } catch (SQLException e) {
                e.printStackTrace();
            }
            });


            logOutB.setOnMouseClicked(event -> {
                logOutB.getScene().getWindow().hide();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("FXML/menu.fxml"));


                try {
                    loader.load();
                } catch (IOException ex) {
                    Logger.getLogger(SortingController.class.getName()).log(Level.SEVERE, null, ex);
                }


                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            });

    }
}
