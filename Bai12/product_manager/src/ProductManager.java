import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductManager {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Them san pham thanh cong");
    }

    public boolean editProduct(int id, String newName, double newPrice) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                return true;
            }
        }

        return false;
    }

    public boolean deleteProduct(int id) {
        for (Product p : products) {
            if (p.getId() == id) {
                products.remove(p);
                return true;
            }
        }
        return false;
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Khong co san pham nao trong danh sach");
            return;
        }
        System.out.println("DANH SACH SAN PHAM");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void searchProductByName(String name) {
        boolean found = false;
        System.out.println("KET QUA TIM KIEM");
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham ten: " + name);
        }
    }

    public void sortPriceAscending() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
        System.out.println("Đã sắp xếp danh sách theo giá TĂNG DẦN.");
    }

    public void sortPriceDescending() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p2.getPrice(), p1.getPrice());
            }
        });
        System.out.println("Đã sắp xếp danh sách theo giá GIẢM DẦN.");
    }
}
