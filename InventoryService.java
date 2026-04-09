import java.util.*;

class InventoryService {

    ProductDAO dao = new ProductDAO();

    // improved method to view products
    public void viewProducts() {
        List<Product> list = dao.getAllProducts();

        if (list.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        for (Product p : list) {
            p.display();
        }
    }

    public void addProduct(Product p) {
        dao.addProduct(p);
    }

    public void deleteProduct(int id) {
        dao.deleteProduct(id);
    }

    public void updateStock(int id, int stock) {
        dao.updateStock(id, stock);
    }
}