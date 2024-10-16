module com.afsifra.fairplay {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fairplay to javafx.fxml;
    exports com.fairplay;
}