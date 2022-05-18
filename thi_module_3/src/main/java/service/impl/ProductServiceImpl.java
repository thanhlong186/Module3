package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();

    @Override
    public List<Product> getAllProduct() {
        List<Product> productList = iProductRepository.getAllProduct();
        if (productList.size() == 0) {
            return null;
        }
        return iProductRepository.getAllProduct();
    }

    @Override
    public void createProduct(Product product) {
                    iProductRepository.createProduct(product);
    }

    @Override
    public Product findByProduct(int id) {
        return iProductRepository.findByProduct(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        iProductRepository.updateProduct(id, product);

    }

    @Override
    public void deleteProduct(int id) {
        iProductRepository.deleteProduct(id);
    }
}
