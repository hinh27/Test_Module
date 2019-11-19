package service;


import  model.Product;
import  repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        productRepository.updateProduct(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public Product findByName(String name) {

        return productRepository.findByName(name);
    }

    @Override
    public boolean checkProduct(Object o) {
        return productRepository.checkProduct(o);
    }

    @Override
    public List sortPrice() {
        return productRepository.sortPrice();
    }
}