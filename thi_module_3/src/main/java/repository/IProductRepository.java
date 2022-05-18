package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAllProduct();

    void createProduct(Product product);

    Product findByProduct(int id);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);
}
