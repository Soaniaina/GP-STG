module JavaFXGraphe {
	requires javafx.controls;
	requires javafx.base;
	requires javafx.graphics;
	

	opens javafx.areachart to javafx.graphics, javafx.fxml;
	opens javafx.blur to javafx.graphics, javafx.fxml;
	opens javafx.piechart to javafx.graphics, javafx.fxml;
}
