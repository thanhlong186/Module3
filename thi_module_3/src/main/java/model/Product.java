package model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private String color;
    private int categoryID;
    private String categoryName;

    public Product() {
    }

    public Product(int productId, String productName,
                   double price, int quantity,
                   String color, int categoryID, String categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public Product(String productName, double price, int quantity, String color, int categoryID) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.categoryID = categoryID;
    }

    public int getProductId() {
        return productId;
    }

    public  void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public  void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public  void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public  void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public  void setColor(String color) {
        this.color = color;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public  void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
