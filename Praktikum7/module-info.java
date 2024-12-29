module JavaFX_MySQL_Project {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	
	opens application.main to javafx.graphics, javafx.fxml;
	opens application.controller to javafx.fxml;
	
}
