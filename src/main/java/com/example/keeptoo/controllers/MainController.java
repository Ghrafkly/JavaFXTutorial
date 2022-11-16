package com.example.keeptoo.controllers;

import com.example.keeptoo.models.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private TableView<Member> tbVMembers;
    @FXML
    private TableColumn<Member, String> tcName, tcMobile, tcEmail, tcAction;
    @FXML
    private Button btnAdd, btnImport, btnExport;
    private ObservableList<Member> data;

    @FXML
    void handleButtonClick(ActionEvent event) {
        System.out.println(event.getSource());
        if (event.getSource() == btnAdd) {
            System.out.println("Add");
        } else if (event.getSource() == btnImport) {
            System.out.println("Import");
        } else if (event.getSource() == btnExport) {
            System.out.println("Export");
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
}