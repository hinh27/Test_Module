package repository;


import model.Product;

import java.util.Comparator;

public class ProductComparator implements Comparator<Product> {
    @Override
    public int compare(Product x, Product y) {
        if (x.getPrice() > y.getPrice()) return 1;
        else if (x.getPrice() < y.getPrice()) return -1;
        else return 0;
    }
}