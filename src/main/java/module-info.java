module view {
    requires javafx.controls;
    requires javafx.fxml;

    opens view to javafx.fxml;
    exports view;

    exports auction;
    opens auction to javafx.fxml;
    exports bidders;
    opens bidders to javafx.fxml;
}