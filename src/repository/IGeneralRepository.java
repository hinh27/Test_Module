package repository;


import java.util.List;

import model.Product;

public interface IGeneralRepository<E> {
    List<E> findAll();

    void addProduct(E e);

    void updateProduct(int id, E e);

    void deleteProduct(int id);

    Product findByName(String name);

    boolean checkProduct(Object o);
}
