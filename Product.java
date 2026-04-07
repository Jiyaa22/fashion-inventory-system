class Product implements Displayable {
    private int id;
    private String name;
    private String brand;
    private String category;
    private double price;
    private double rating;
    private int stock;

    public Product(int id, String name, String brand, String category,
                   double price, double rating, int stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    public void display() {
        System.out.println(id + " | " + name + " | " + brand +
                " | ₹" + price + " | Stock: " + stock);
    }
}