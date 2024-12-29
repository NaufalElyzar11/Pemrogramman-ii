package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/Perpustakaan";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection connect() throws Exception {
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(DB_URL, USER, PASS);
    }

    public static void addPelanggan(String nama, String email, String telepon) throws Exception {
        String query = "INSERT INTO Pelanggan (nama, email, telepon) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, telepon);
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                }
            }
        }
    }


    public static void addBuku(String judul, String penulis, int harga, int stok) throws Exception {
        String query = "INSERT INTO Buku (judul, penulis, harga, stok) VALUES (?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setInt(3, harga);
            stmt.setInt(4, stok);
            stmt.executeUpdate();

            // Get generated buku_id
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                }
            }
        }
    }

    
    public static void addPenjualan(int jumlah, int total_harga, String tanggal, int pelanggan_id, int buku_id) throws Exception {
        String query = "INSERT INTO Penjualan (jumlah, total_harga, tanggal, pelanggan_id, buku_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, jumlah);
            stmt.setInt(2, total_harga);
            stmt.setString(3, tanggal);
            stmt.setInt(4, pelanggan_id);
            stmt.setInt(5, buku_id);
            stmt.executeUpdate();

            // Get generated penjualan_id
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                }
            }
        }
    }



    // Read Methods
    public static List<String> getPelanggan() throws Exception {
        String query = "SELECT * FROM Pelanggan";
        List<String> result = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getString("pelanggan_id") + ", " + rs.getString("nama") + ", " + rs.getString("email") + ", " + rs.getInt("telepon"));
            }
        }
        return result;
    }

    public static List<String> getBuku() throws Exception {
        String query = "SELECT * FROM Buku";
        List<String> result = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getString("buku_id") + ", " + rs.getString("judul") + ", " + rs.getString("penulis") + ", " + rs.getInt("harga") + ", " + rs.getInt("stok"));
            }
        }
        return result;
    }

    public static List<String> getPenjualan() throws Exception {
        String query = "SELECT * FROM Penjualan";
        List<String> result = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                result.add(rs.getString("penjualan_id") + ", " + rs.getInt("jumlah") + ", " + rs.getInt("total_harga") + ", " + rs.getDate("tanggal") + ", " + rs.getString("pelanggan_id") + ", " + rs.getString("buku_id"));
            }
        }
        return result;
    }

    // Update Methods
    public static void updatePelanggan(String pelanggan_id, String nama, String email, String telepon) throws Exception {
        String query = "UPDATE Pelanggan SET nama = ?, email = ?, telepon = ? WHERE pelanggan_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, nama);
            stmt.setString(2, email);
            stmt.setString(3, telepon);
            stmt.setString(4, pelanggan_id);
            stmt.executeUpdate();
        }
    }

    public static void updateBuku(String buku_id, String judul, String penulis, int harga, int stok) throws Exception {
        String query = "UPDATE Buku SET judul = ?, penulis = ?, harga = ?, stok = ? WHERE buku_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, judul);
            stmt.setString(2, penulis);
            stmt.setInt(3, harga);
            stmt.setInt(4, stok);
            stmt.setString(5, buku_id);
            stmt.executeUpdate();
        }
    }

    public static void updatePenjualan(String penjualan_id, int jumlah, int total_harga, String tanggal, String pelanggan_id, String buku_id) throws Exception {
        String query = "UPDATE Penjualan SET jumlah = ?, total_harga = ?, tanggal = ?, pelanggan_id = ?, buku_id = ? WHERE penjualan_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, jumlah);
            stmt.setInt(2, total_harga);
            stmt.setString(3, tanggal);
            stmt.setString(4, pelanggan_id);
            stmt.setString(5, buku_id);
            stmt.setString(6, penjualan_id);
            stmt.executeUpdate();
        }
    }

    // Delete Methods
    public static void deletePelanggan(String pelanggan_id) throws Exception {
        String query = "DELETE FROM Pelanggan WHERE pelanggan_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, pelanggan_id);
            stmt.executeUpdate();
        }
    }

    public static void deleteBuku(String buku_id) throws Exception {
        String query = "DELETE FROM Buku WHERE buku_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, buku_id);
            stmt.executeUpdate();
        }
    }

    public static void deletePenjualan(String penjualan_id) throws Exception {
        String query = "DELETE FROM Penjualan WHERE penjualan_id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, penjualan_id);
            stmt.executeUpdate();
        }
    }
}
