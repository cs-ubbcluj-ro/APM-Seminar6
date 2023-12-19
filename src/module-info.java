module gui {
    requires javafx.controls;
    requires javafx.fxml;

    opens threads to javafx.fxml;
    exports threads;
    exports main;
}