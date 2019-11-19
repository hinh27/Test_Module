package repository;

import model.Product;

import java.util.List;


public interface ProductRepository extends IGeneralRepository<Product>{
    List<Product> sortPrice();
}