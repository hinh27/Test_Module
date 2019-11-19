package repository;

import model.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ProductRepositoryImpl implements ProductRepository {
    ArrayList<Product> listProducts = new ArrayList<>();
    {
        listProducts.add(new Product(1, " Lamborghini Aventador SVJ ",500000));
        listProducts.add(new Product(2, " Lamborghini Huracan ",260000));
        listProducts.add(new Product(3,  " LaFerrari ",1400000));
        listProducts.add(new Product(4, " Ferrari F12 Berlinetta ",320000));
        listProducts.add(new Product(5, " Bugatti Chiron ",3000000));
        listProducts.add(new Product(6, " Bugatti La Voiture Noire ",18000000));

    }


    @Override
    public List<Product> findAll() {
        return listProducts;
    }

    @Override
    public void addProduct(Product product) {
        listProducts.add(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        int index = -1;
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        listProducts.set(index, product);

    }

    @Override
    public void deleteProduct(int id) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getId() == id) {
                listProducts.remove(i);
                return;
            }
        }
    }

    @Override
    public Product findByName(String name) {
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getName().contains(name)) {
                return listProducts.get(i);
            }

        }
        return null;
    }

    @Override
    public boolean checkProduct(Object o) {
        boolean check = false;
        int id = -1;

        try {
            id = (int) o;
        } catch (Exception e) {

        }
        for (int i = 0; i < listProducts.size(); i++) {
            if (listProducts.get(i).getName().equals(o) || listProducts.get(i).getId() == id) {
                check = true;
                break;
            }
        }
        return check;
    }


    @Override
    public List<Product> sortPrice() {
        Collections.sort(listProducts, new ProductComparator());
        return listProducts;

    }

}
