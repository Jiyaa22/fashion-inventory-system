import java.util.*;

class InventoryService {

    ProductDAO dao = new ProductDAO();

    public void viewProducts() {
        List<Product> list = dao.getAllProducts();

        for (int i = 0; i < list.size(); i++) {
            list.get(i).display();
        }
    }

    public void addProduct(Product p) {
        dao.addProduct(p);
    }
}