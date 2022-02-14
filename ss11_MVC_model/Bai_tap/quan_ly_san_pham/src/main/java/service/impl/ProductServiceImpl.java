package service.impl;

import model.Product;
import service.ProductService;

import java.util.*;

public class ProductServiceImpl implements ProductService {

    private static Map<Integer, Product> products;
    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Ford", 853.0, "Ford Ranger", "Mỹ"));
        products.put(2, new Product(2, "Wolkswagen", 899.0, "Wolkswagen Jetta ", "Đức"));
        products.put(3, new Product(3, "Toyota", 720.0, "Toyota Corolla Cross", "Nhật"));
        products.put(4, new Product(4, "Peugeot", 739.0, "Peugeot 2008 ", "Pháp"));
        products.put(5, new Product(5, "Cadillac", 1094.0, "Cadillac CT6", "Anh"));
        products.put(6, new Product(6, "Bentley", 18000.0, "Phiên bản Continental 2021", "Anh"));
        products.put(7, new Product(7, "Tesla", 1154.6, "Tesla Model 3", "Mỹ"));
        products.put(8, new Product(8, "Subaru", 1598.0, "Subaru XV", "Nhật Bản"));
        products.put(9, new Product(9, "Audi", 4500.0, "Audi Q8", "Đức"));
        products.put(10, new Product(10, "Mazda", 750.0, "Mazda 3", "Nhật Bản"));
        products.put(11, new Product(11, "Mercedes-Benz", 1529.0, "Mercedes-Benz CLA 200", "Đức"));
        products.put(12, new Product(12, "BMW", 8800.0, "BMW 750Li", "Đức"));
        products.put(13, new Product(13, "Lexus", 2500.0, "Lexus ES250", "Nhật Bản"));
        products.put(14, new Product(14, "Lamborghini", 26000.0, "Phiên bản Aventador LP 700-4", "Italia"));
        products.put(15, new Product(15, "Land Rover", 4939.0, "Ranger Rover Sport", "Anh"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }


    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> search(String name) {
        List<Product> products = this.findAll();
        List<Product> productResult = new ArrayList<>();
        String productName;
        name = name.toLowerCase();
        for(Product product : products) {
            productName = product.getName().toLowerCase();
            if (productName.contains(name)){
                productResult.add(product);
            }
        }
        return productResult;
    }

}
