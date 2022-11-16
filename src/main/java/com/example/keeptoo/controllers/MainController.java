package com.example.keeptoo.controllers;

import com.example.keeptoo.models.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TableView<Member> tbVMembers;
    @FXML
    private TableColumn<Member, String> tcName, tcMobile, tcEmail, tcAction;
    @FXML
    private Button btnAdd, btnImport, btnExport;
    public static Stage pStage;
    private ObservableList<Member> data;

    @FXML
    void handleButtonClick(ActionEvent event) {
        if (event.getSource() == btnAdd) {
            showDialog("addnew");
        } else if (event.getSource() == btnImport) {
            showDialog("import");
        } else if (event.getSource() == btnExport) {
            showDialog("export");
        }
    }

    private void showDialog(String fxml) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/keeptoo/fxml/%s.fxml".formatted(fxml))));
            Stage stage = new Stage();
            Scene scene = new Scene(parent);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setAlwaysOnTop(true);
            stage.setX(pStage.getX() + 200);
            stage.setY(pStage.getY() + 100);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tcName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tcMobile.setCellValueFactory(new PropertyValueFactory<>("Mobile"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));
        tcAction.setCellValueFactory(new PropertyValueFactory<>("Action"));

        data = FXCollections.observableArrayList(
                new Member("John Doe", "123456789", "johndoe@email.com", "Call"),
                new Member("Jane Doe", "987654321", "janedone@email.com", "Call")
        );
        tbVMembers.setItems(data);
    }

    public Stage getpStage() {
        return pStage;
    }
}