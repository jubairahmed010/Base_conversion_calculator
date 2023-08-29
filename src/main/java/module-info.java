module com.cal.calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.cal.calculator to javafx.fxml;
    exports com.cal.calculator;
}