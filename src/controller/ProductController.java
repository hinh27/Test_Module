package controller;

import  model.Product;
import  service.ProductServiceImpl;

import java.util.List;

public class ProductController {
    ProductServiceImpl productService = new ProductServiceImpl();

    public List<Product> getProducts() {
        return productService.findAll();
    }

    public void addProduct(Product product) {
        productService.addProduct(product);
    }

    public void updateProduct(int id, Product product) {
        productService.updateProduct(id, product);
    }

    public void deleteProduct(int id) {
        productService.deleteProduct(id);
    }

    public Product findByName(String name) {
        return productService.findByName(name);
    }

    public boolean check(Object o) {
        return productService.checkProduct(o);
    }

    public List<Product> sortPrice() {
        return productService.sortPrice();
    }
}