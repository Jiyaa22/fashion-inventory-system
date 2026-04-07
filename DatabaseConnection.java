import java.sql.*;

class DatabaseConnection {

    private static final String URL = "jdbc:sqlite:products.db";

    public static Connecation connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        }
        return DriverManager.getConnection(URL);
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS products (" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT, " +
                "brand TEXT, " +
                "category TEXT, " +
                "price REAL, " +
                "rating REAL, " +
                "stock INTEGER)";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sql);

        } catch (SQLException e) {
            System.out.println("Error creating table");
        }
    }
}
