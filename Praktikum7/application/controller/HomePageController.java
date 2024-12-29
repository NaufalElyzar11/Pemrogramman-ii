package application.controller;

import application.Database;
import application.Buku;
import application.Pelanggan;
import application.Penjualan;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import java.sql.Date;
import java.sql.PreparedStatement;

public class HomePageController {

    @FXML
    private TableView<Pelanggan> tabelPelanggan;
    @FXML
    private TableColumn<Pelanggan, String> namaColumn;
    @FXML
    private TableColumn<Pelanggan, String> emailColumn;
    @FXML
    private TableColumn<Pelanggan, String> teleponColumn;
    @FXML
    private TextField namaField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField teleponField;
    @FXML
    private Button buttonAddPelanggan, buttonEditPelanggan, buttonDeletePelanggan;
    private ObservableList<Pelanggan> pelangganList;

    @FXML
    private TableView<Buku> tabelBuku;
    @FXML
    private TableColumn<Buku, String> judulColumn;
    @FXML
    private TableColumn<Buku, String> penulisColumn;
    @FXML
    private TableColumn<Buku, Integer> hargaColumn;
    @FXML
    private TableColumn<Buku, Integer> stokColumn;
    @FXML
    private TextField judulField, penulisField, hargaField, stokField;
    @FXML
    private Button buttonAddBuku, buttonEditBuku, buttonDeleteBuku;
    private ObservableList<Buku> bukuList;

    @FXML
    private TableView<Penjualan> tabelPenjualan;
    @FXML
    private TableColumn<Penjualan, Integer> idPenjualanColumn;
    @FXML
    private TableColumn<Penjualan, Integer> idBukuColumn;
    @FXML
    private TableColumn<Penjualan, Integer> idPelangganColumn;
    @FXML
    private TableColumn<Penjualan, Double> totalHargaColumn;
    @FXML
    private TableColumn<Penjualan, Integer> jumlahColumn;
    @FXML
    private TableColumn<Penjualan, Date> tanggalColumn;
    @FXML
    private ComboBox<Integer> bukuComboBox;
    @FXML
    private ComboBox<Integer> pelangganComboBox;
    @FXML
    private TextField jumlahField;
    @FXML
    private DatePicker tanggalPicker;
    @FXML
    private Button buttonAddPenjualan, buttonEditPenjualan, buttonDeletePenjualan;
    private ObservableList<Penjualan> penjualanList;
        
    public void initialize() {
        initializePelanggan();
        initializeBuku();
        initializePenjualan();
        
        loadBukuData();  
        loadPelangganData();
        
        buttonAddPenjualan.setOnAction(e -> onAddPenjualan());
        buttonEditPenjualan.setOnAction(e -> onEditPenjualan());
        buttonDeletePenjualan.setOnAction(e -> onDeletePenjualan());
    }

    private void initializePelanggan() {
        namaColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNama()));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));
        teleponColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelepon()));
        loadDataPelanggan();
    }

    private void initializeBuku() {
        judulColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getJudul()));
        penulisColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPenulis()));
        hargaColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getHarga()).asObject());
        stokColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getStok()).asObject());
        loadDataBuku();
    }

    private void initializePenjualan() {
        idPenjualanColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPenjualanID()).asObject());
        idBukuColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getBukuID()).asObject());
        idPelangganColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getPelangganID()).asObject());
        totalHargaColumn.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getTotalHarga()).asObject());
        tanggalColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTanggal()));
        jumlahColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getJumlah()).asObject());
        
        loadDataPenjualan();
    }

    private void loadDataPelanggan() {
        pelangganList = FXCollections.observableArrayList();
        try (Connection conn = Database.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM pelanggan")) {
            while (rs.next()) {
                pelangganList.add(new Pelanggan(rs.getInt("pelanggan_id"), rs.getString("nama"), rs.getString("email"), rs.getString("telepon")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabelPelanggan.setItems(pelangganList);
    }

    private void loadDataBuku() {
        bukuList = FXCollections.observableArrayList();
        try (Connection conn = Database.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM buku")) {
            while (rs.next()) {
                bukuList.add(new Buku(rs.getInt("buku_id"), rs.getString("judul"), rs.getString("penulis"), rs.getInt("harga"), rs.getInt("stok")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        tabelBuku.setItems(bukuList);
    }

    private void loadDataPenjualan() {
        penjualanList = FXCollections.observableArrayList();
        try (Connection conn = Database.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT * FROM penjualan")) {
            while (rs.next()) {
                penjualanList.add(new Penjualan(
                        rs.getInt("penjualan_id"),
                        rs.getInt("buku_id"),
                        rs.getInt("pelanggan_id"),
                        rs.getInt("jumlah"),
                        rs.getDouble("total_harga"),
                        rs.getDate("tanggal")
                ));
            }
        } catch (Exception e) {
            showErrorAlert("Error loading penjualan data", e.getMessage());
        }
        tabelPenjualan.setItems(penjualanList);
    }
    
    private void loadBukuData() {
        ObservableList<Integer> bukuIdList = FXCollections.observableArrayList();
        try (Connection conn = Database.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT buku_id FROM buku")) {
            while (rs.next()) {
                bukuIdList.add(rs.getInt("buku_id"));
            }
        } catch (Exception e) {
            showErrorAlert("Error loading buku data", e.getMessage());
        }
        bukuComboBox.setItems(bukuIdList);
    }

    private ObservableList<Integer> pelangganIdList;

    private void loadPelangganData() {
        pelangganIdList = FXCollections.observableArrayList();
        try (Connection conn = Database.connect();
             Statement stat = conn.createStatement();
             ResultSet rs = stat.executeQuery("SELECT pelanggan_id FROM pelanggan")) {
            while (rs.next()) {
                pelangganIdList.add(rs.getInt("pelanggan_id"));
            }
        } catch (Exception e) {
            showErrorAlert("Error loading pelanggan data", e.getMessage());
        }
        pelangganComboBox.setItems(pelangganIdList);
    }

    @FXML
    private void onAddPelanggan() {
        try {
            String nama = namaField.getText();
            String email = emailField.getText();
            String telepon = teleponField.getText();

            Database.addPelanggan(nama, email, telepon);

            loadDataPelanggan();

            clearFields();
            showAlert("Success", "Data added successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to add data: " + e.getMessage());
        }
    }


    @FXML
    private void onEditPelanggan() {
        try {
            Pelanggan selectedPelanggan = tabelPelanggan.getSelectionModel().getSelectedItem();
            if (selectedPelanggan == null) {
                showAlert("Warning", "Please select a customer to edit.");
                return;
            }

            int pelanggan_id = selectedPelanggan.getPelangganID();
            String nama = namaField.getText();
            String email = emailField.getText();
            String telepon = teleponField.getText();

            if (nama.isEmpty() || email.isEmpty() || telepon.isEmpty()) {
                showAlert("Warning", "All fields must be filled.");
                return;
            }

            Database.updatePelanggan(String.valueOf(pelanggan_id), nama, email, telepon);

            selectedPelanggan.setNama(nama);
            selectedPelanggan.setEmail(email);
            selectedPelanggan.setTelepon(telepon);

            tabelPelanggan.refresh();
            clearFields();
            showAlert("Success", "Data updated successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to update data: " + e.getMessage());
        }
    }



    @FXML
    private void onDeletePelanggan() {
        try {
            Pelanggan selectedPelanggan = tabelPelanggan.getSelectionModel().getSelectedItem();
            if (selectedPelanggan == null) {
                showAlert("Warning", "Please select a customer to delete.");
                return;
            }


            Database.deletePelanggan(String.valueOf(selectedPelanggan.getPelangganID()));

            pelangganList.remove(selectedPelanggan);

            clearFields();
            showAlert("Success", "Data deleted successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to delete data: " + e.getMessage());
        }
    }
    
    @FXML
    private void onAddBuku() {
        try {
            String judul = judulField.getText();
            String penulis = penulisField.getText();
            int harga = Integer.parseInt(hargaField.getText());
            int stok = Integer.parseInt(stokField.getText());

            Database.addBuku(judul, penulis, harga, stok);

            bukuList.add(new Buku(0, judul, penulis, harga, stok)); 

            clearFields();
            showAlert("Success", "Data added successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to add data: " + e.getMessage());
        }
    }
    
    @FXML
    private void onEditBuku() {
        try {
            Buku selectedBuku = tabelBuku.getSelectionModel().getSelectedItem();
            if (selectedBuku == null) {
                showAlert("Warning", "Please select a book to edit.");
                return;
            }

            int bukuId = selectedBuku.getBukuID();
            String judul = judulField.getText();
            String penulis = penulisField.getText();
            int harga = Integer.parseInt(hargaField.getText());
            int stok = Integer.parseInt(stokField.getText());

            if (judul.isEmpty() || penulis.isEmpty()) {
                showAlert("Warning", "All fields must be filled.");
                return;
            }

            Database.updateBuku(String.valueOf(bukuId), judul, penulis, harga, stok);

            selectedBuku.setJudul(judul);
            selectedBuku.setPenulis(penulis);
            selectedBuku.setHarga(harga);
            selectedBuku.setStok(stok);

            tabelBuku.refresh();
            clearFields();
            showAlert("Success", "Book data updated successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to update book data: " + e.getMessage());
        }
    }

    @FXML
    private void onDeleteBuku() {
        try {
            Buku selectedBuku = tabelBuku.getSelectionModel().getSelectedItem();
            if (selectedBuku == null) {
                showAlert("Warning", "Please select a book to delete.");
                return;
            }

            Database.deleteBuku(String.valueOf(selectedBuku.getBukuID()));

            bukuList.remove(selectedBuku);

            clearFields();
            showAlert("Success", "Book data deleted successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to delete book data: " + e.getMessage());
        }
    }

    
    private void onAddPenjualan() {
        try (Connection conn = Database.connect()) {
            // Ambil detail buku
            String bukuQuery = "SELECT harga, stok FROM buku WHERE buku_id = ?";
            PreparedStatement bukuStmt = conn.prepareStatement(bukuQuery);
            bukuStmt.setInt(1, bukuComboBox.getValue());
            ResultSet rs = bukuStmt.executeQuery();

            if (rs.next()) {
                double harga = rs.getDouble("harga");
                int stok = rs.getInt("stok");

                // Validasi jumlah
                int jumlah = Integer.parseInt(jumlahField.getText());
                if (jumlah > stok) {
                    showErrorAlert("Error", "Jumlah melebihi stok yang tersedia.");
                    return;
                }

                // Hitung total harga
                double totalHarga = harga * jumlah;

                // Masukkan penjualan ke database
                String insertQuery = "INSERT INTO penjualan (buku_id, pelanggan_id, jumlah, total_harga, tanggal) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(insertQuery);
                pstmt.setInt(1, bukuComboBox.getValue());
                pstmt.setInt(2, pelangganComboBox.getValue());
                pstmt.setInt(3, jumlah);
                pstmt.setDouble(4, totalHarga);
                pstmt.setDate(5, Date.valueOf(tanggalPicker.getValue()));
                pstmt.executeUpdate();

                // Update stok buku
                String updateStokQuery = "UPDATE buku SET stok = stok - ? WHERE buku_id = ?";
                PreparedStatement updateStokStmt = conn.prepareStatement(updateStokQuery);
                updateStokStmt.setInt(1, jumlah);
                updateStokStmt.setInt(2, bukuComboBox.getValue());
                updateStokStmt.executeUpdate();

                loadDataPenjualan();
            } else {
                showErrorAlert("Error", "Buku tidak ditemukan.");
            }
        } catch (Exception e) {
            showErrorAlert("Error adding penjualan", e.getMessage());
        }
    }
    
    @FXML
    private void onEditPenjualan() {
        Penjualan selectedPenjualan = tabelPenjualan.getSelectionModel().getSelectedItem();
        if (selectedPenjualan == null) {
            showErrorAlert("No Selection", "Please select a penjualan to edit.");
            return;
        }

        try (Connection conn = Database.connect()) {
            // Validasi input
            int bukuId = bukuComboBox.getValue();
            int pelangganId = pelangganComboBox.getValue();
            int jumlah = Integer.parseInt(jumlahField.getText());

            // Ambil detail buku
            String bukuQuery = "SELECT harga, stok FROM buku WHERE buku_id = ?";
            PreparedStatement bukuStmt = conn.prepareStatement(bukuQuery);
            bukuStmt.setInt(1, bukuId);
            ResultSet rs = bukuStmt.executeQuery();

            if (rs.next()) {
                double harga = rs.getDouble("harga");
                int stok = rs.getInt("stok");

                if (jumlah > stok) {
                    showErrorAlert("Error", "Jumlah melebihi stok yang tersedia.");
                    return;
                }

                double totalHarga = harga * jumlah;

                // Update penjualan di database
                String updateQuery = "UPDATE penjualan SET buku_id = ?, pelanggan_id = ?, jumlah = ?, total_harga = ?, tanggal = ? WHERE penjualan_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(updateQuery);
                pstmt.setInt(1, bukuId);
                pstmt.setInt(2, pelangganId);
                pstmt.setInt(3, jumlah);
                pstmt.setDouble(4, totalHarga);
                pstmt.setDate(5, Date.valueOf(tanggalPicker.getValue()));
                pstmt.setInt(6, selectedPenjualan.getPenjualanID());
                pstmt.executeUpdate();

                loadDataPenjualan();
            } else {
                showErrorAlert("Error", "Buku tidak ditemukan.");
            }
        } catch (Exception e) {
            showErrorAlert("Error editing penjualan", e.getMessage());
        }
    }

    private void onDeletePenjualan() {
        Penjualan selectedPenjualan = tabelPenjualan.getSelectionModel().getSelectedItem();
        if (selectedPenjualan == null) {
            showErrorAlert("No Selection", "Please select a penjualan to delete.");
            return;
        }

        try (Connection conn = Database.connect()) {
            String deleteQuery = "DELETE FROM penjualan WHERE penjualan_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, selectedPenjualan.getPenjualanID());
            pstmt.executeUpdate();

            loadDataPenjualan();
        } catch (Exception e) {
            showErrorAlert("Error deleting penjualan", e.getMessage());
        }
    }


    
    private void clearFields() {
        namaField.clear();
        emailField.clear();
        teleponField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private void showErrorAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
