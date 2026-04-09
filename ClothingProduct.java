class ClothingProduct extends Product {

    private String fabric;

    public ClothingProduct(int id, String name, String brand, String category,
                           double price, double rating, int stock, String fabric) {
        super(id, name, brand, category, price, rating, stock);
        this.fabric = fabric;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Fabric: " + fabric);
    }
}