import java.sql.*;
import java.util.*;

class ProductDAO {

    public void addProduct(Product p) {
        String sql = "INSERT INTO products VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getName());
            stmt.setString(3, p.getBrand());
            stmt.setString(4, p.getCategory());
            stmt.setDouble(5, p.getPrice());
            stmt.setDouble(6, p.getRating());
            stmt.setInt(7, p.getStock());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error adding product");
        }
    }
    public void updateProduct(Product p) {
        String sql = "UPDATE products SET name=?, brand=?, category=?, price=?, rating=?, stock=? WHERE id=?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getName());
            stmt.setString(2, p.getBrand());
            stmt.setString(3, p.getCategory());
            stmt.setDouble(4, p.getPrice());
            stmt.setDouble(5, p.getRating());
            stmt.setInt(6, p.getStock());
            stmt.setInt(7, p.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error updating product");
        }
    }

    public void searchProduct(String name) {
        String sql = "SELECT * FROM products WHERE name LIKE ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("brand"),
                    rs.getString("category"),
                    rs.getDouble("price"),
                    rs.getDouble("rating"),
                    rs.getInt("stock")
                );
                p.display();
            }

        } catch (Exception e) {
            System.out.println("Error searching product");
        }
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products";

        try (Connection conn = DatabaseConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getDouble("rating"),
                        rs.getInt("stock")
                );
                list.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error fetching products");
        }

        return list;
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id=?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error deleting product");
        }
    }

    public void updateStock(int id, int stock) {
        String sql = "UPDATE products SET stock=? WHERE id=?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, stock);
            stmt.setInt(2, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error updating stock");
        }
    }
}