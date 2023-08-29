package com.cal.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;

public class CalculatorController implements Initializable {

    @FXML
    private TextField inputField;

    @FXML
    private Label outputLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        outputLabel.setText("No Input");
        inputField.setOnMouseClicked(this::handleTextFieldClick);
    }
    private void handleTextFieldClick(MouseEvent event) {

            inputField.clear();
    }


    @FXML
    void clear(ActionEvent event) {
        inputField.clear();
        outputLabel.setText("No Input");
        inputField.setText("Place decimal input here");

    }

    @FXML
    void convertToBinary(ActionEvent event) {
        String input = inputField.getText();
        if (isValidDecimal(input)) {
            double decimal = Double.parseDouble(input);
            if (decimal == (int) decimal) {
                int intValue = (int) decimal;
                String binary = Integer.toBinaryString(intValue);
                outputLabel.setText(binary);
            } else {
                outputLabel.setText("No input given");
            }
        } else {
            outputLabel.setText("Not a Number!");
        }
    }

    @FXML
    void convertToHexadecimal(ActionEvent event) {
        String input = inputField.getText();
        if (isValidDecimal(input)) {
            double decimal = Double.parseDouble(input);
            if (decimal == (int) decimal) {
                int intValue = (int) decimal;
                String hexadecimal = Integer.toHexString(intValue);
                outputLabel.setText(hexadecimal);
            } else {
                outputLabel.setText("No input given");
            }
        } else {
            outputLabel.setText("Not a Number!");
        }
    }

    @FXML
    void convertToOctal(ActionEvent event) {
        String input = inputField.getText();
        if (isValidDecimal(input)) {
            double decimal = Double.parseDouble(input);
            if (decimal == (int) decimal) {
                int intValue = (int) decimal;
                String octal = Integer.toOctalString(intValue);
                outputLabel.setText(octal);
            } else {
                outputLabel.setText("No input given");
            }
        } else {
            outputLabel.setText("Not a Number!");
        }
    }

    @FXML
    void exitActionHandler(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void gotoNextPage(ActionEvent event) throws IOException  {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("nextPage.fxml")));

        Stage window = (Stage) ((Node) (event.getSource())).getScene().getWindow();
        window.setScene(new Scene(root, 600, 400));
        window.show();
    }

    private boolean isValidDecimal(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}





