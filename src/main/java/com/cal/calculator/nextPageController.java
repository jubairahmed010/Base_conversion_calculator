package com.cal.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class nextPageController {

    @FXML
    private void goBack(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Calculator.fxml")));

        Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
        window.show();
    }

}
