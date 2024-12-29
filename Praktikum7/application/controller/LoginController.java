package application.controller;

import java.io.IOException;

import application.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField userField;
	@FXML
	private PasswordField passField;
	
	@FXML
	public void login(ActionEvent event) {
		try {
			Parent homepage = FXMLLoader.load(getClass().getResource("/application/HomePageView.fxml"));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			Alert alert;
			if(UserData.validateUser(userField.getText(), passField.getText())) {
				alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Login Sukses");
                alert.setHeaderText(null);
                alert.setContentText("Selamat Datang, "+ userField.getText() + "!");
                
                Scene scene = new Scene(homepage);
                stage.setScene(scene);
                stage.show();                
			}
			else {
				alert = new Alert(AlertType.ERROR);
                alert.setTitle("Login Gagal");
                alert.setHeaderText(null);
                alert.setContentText("Username atau password tidak valid!");
			}
			
			alert.setX(470);
            alert.setY(290);
            alert.showAndWait();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
