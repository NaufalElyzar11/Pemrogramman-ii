package praktikum6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Praktikum6 extends Application {

    @Override
    public void start(Stage primaryStage) {
        TableView<Mahasiswa> tableView = new TableView<>();

        TableColumn<Mahasiswa, String> nimColumn = new TableColumn<>("NIM");
        nimColumn.setMinWidth(150);
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("nim"));

        TableColumn<Mahasiswa, String> namaColumn = new TableColumn<>("Nama");
        namaColumn.setMinWidth(200);
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("nama"));

        tableView.getColumns().addAll(nimColumn, namaColumn);

        ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
            new Mahasiswa("23108", "Freya"),
            new Mahasiswa("12346", "Nopal"),
            new Mahasiswa("23104", "Gita"),
            new Mahasiswa("12348", "Rosyid"),
            new Mahasiswa("21765", "Bima"),
            new Mahasiswa("12350", "Hafizh"),
            new Mahasiswa("12351", "Gita"),
            new Mahasiswa("12352", "Hendra"),
            new Mahasiswa("12353", "Hendri"),
            new Mahasiswa("12354", "Cinco")
        );

        tableView.setItems(data);

        VBox vbox = new VBox(tableView);

        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setTitle("Praktikum 6 - Data Mahasiswa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
