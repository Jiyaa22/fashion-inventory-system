import java.awt.*;
import java.util.List;
import javax.swing.*;

public class InventoryGUI extends JFrame {

    InventoryService service = new InventoryService();

    JTextField idField, nameField, brandField, categoryField, priceField, ratingField, stockField;
    JTextArea outputArea;

    public InventoryGUI() {
        setTitle("Inventory Management System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        idField = new JTextField();
        nameField = new JTextField();
        brandField = new JTextField();
        categoryField = new JTextField();
        priceField = new JTextField();
        ratingField = new JTextField();
        stockField = new JTextField();

        inputPanel.add(new JLabel("ID")); inputPanel.add(idField);
        inputPanel.add(new JLabel("Name")); inputPanel.add(nameField);
        inputPanel.add(new JLabel("Brand")); inputPanel.add(brandField);
        inputPanel.add(new JLabel("Category")); inputPanel.add(categoryField);
        inputPanel.add(new JLabel("Price")); inputPanel.add(priceField);
        inputPanel.add(new JLabel("Rating")); inputPanel.add(ratingField);
        inputPanel.add(new JLabel("Stock")); inputPanel.add(stockField);

        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();

        JButton addBtn = new JButton("Add Product");
        JButton viewBtn = new JButton("View Products");
        JButton deleteBtn = new JButton("Delete Product");
        JButton updateStockBtn = new JButton("Update Stock");

        buttonPanel.add(addBtn);
        buttonPanel.add(viewBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(updateStockBtn);

        add(buttonPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        // ADD PRODUCT
        addBtn.addActionListener(e -> {
            try {
                Product p = new Product(
                        Integer.parseInt(idField.getText()),
                        nameField.getText(),
                        brandField.getText(),
                        categoryField.getText(),
                        Double.parseDouble(priceField.getText()),
                        Double.parseDouble(ratingField.getText()),
                        Integer.parseInt(stockField.getText())
                );

                service.addProduct(p);
                outputArea.setText("Product Added Successfully!");
            } catch (Exception ex) {
                outputArea.setText("Error adding product");
            }
        });

        // VIEW PRODUCTS
        viewBtn.addActionListener(e -> {
            List<Product> list = service.dao.getAllProducts();
            outputArea.setText("");

            for (Product p : list) {
                outputArea.append(p.getId() + " | " + p.getName() + " | ₹" + p.getPrice() + " | Stock: " + p.getStock() + "\n");
            }
        });
    }
}

