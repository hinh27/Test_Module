package test;


import  controller.ProductController;
import  model.Product;

import java.util.List;
import java.util.Scanner;

public class ProductTest {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            ProductTest.menu();
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    List<Product> productList = productController.getProducts();
                    for (Product p : productList) {
                        System.out.println("ID:\t " + p.getId() + "\t NAME: " + p.getName() + "\tPRICE: " + p.getPrice());
                    }
                    break;
                }
                case 2: {
                    Product product = ProductTest.productFormAdd();
                    productController.addProduct(product);
                    break;
                }
                case 3: {
                    int id = input.nextInt();
                    if (productController.check(id) == true) {
                        Product product = ProductTest.productFromUpdate();
                        productController.updateProduct(id, product);
                    } else {
                        System.out.println("Sản phẩm không tồn tại");
                    }

                    break;
                }
                case 4: {
                    System.out.println("Nhập id sản phẩm cần xóa: ");
                    int id = input.nextInt();
                    if (productController.check(id) == true) {
                        productController.deleteProduct(id);
                    } else {
                        System.out.println("Sản phẩm này không tồn tại <3 ");
                    }
                    break;
                }
                case 5: {
                    System.out.println("Nhập tên sản phẩm cần tìm");
                    String nameSp = new Scanner(System.in).nextLine();
                    Product product = productController.findByName(nameSp);
                    if (product != null) {
                        System.out.println("ID:\t " + product.getId() + "\t NAME: " + product.getName() + "\tPRICE: " + product.getPrice());
                    } else {
                        System.out.println( "Không tìm thấy tên sản phẩm");
                    }

                    break;
                }
                case 6: {
                    List<Product> productList = productController.sortPrice();
                    for (Product p : productList) {
                        System.out.println("ID:\t " + p.getId() + "\t NAME: " + p.getName() + "\tPRICE: " + p.getPrice());
                    }

                    break;
                }


                case 0: {
                    System.out.println("Exit");
                    break;
                }
            }

        } while (choice != 0);
    }

    public static void menu() {
        System.out.println("===============>.<===============");
        System.out.println("Menu");
        System.out.println("1. Danh sách sản phẩm");
        System.out.println("2. Thêm mới sản phẩm");
        System.out.println("3.  Thay đổi thông tin sản phẩm");
        System.out.println("4. Xóa sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm");
        System.out.println("6. Sắp xếp sản phẩm");
        System.out.println("0. Exit");
        System.out.println("Nhập vào lựa chọn :");
    }

    public static Product productFormAdd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm :");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập tên sản phẩm : ");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm :");
        double price = scanner.nextDouble();
        scanner.nextLine();
        Product product = new Product(id, name, price );
        return product;
    }

    public static Product productFromUpdate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New id :");
        int newId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("new name :");
        String newName = scanner.nextLine();
        System.out.println("New price :");
        double newPrice = scanner.nextDouble();
        scanner.nextLine();
        Product newProduct = new Product(newId, newName, newPrice);
        return newProduct;
    }
}
