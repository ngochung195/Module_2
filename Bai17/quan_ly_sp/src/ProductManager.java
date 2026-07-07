import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private final String filePath;

    public ProductManager(String filePath) {
        this.filePath = filePath;
    }

    public void saveToFile(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(products);
        } catch (IOException e) {
            System.err.println("Loi khi ghi file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public List<Product> loadFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Loi khi doc file (co the file rong hoac sai dinh dang): " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public void addProduct(Product product) {
        List<Product> products = loadFromFile();
        products.add(product);
        saveToFile(products);
        System.out.println("Them san pham thanh cong!");
    }

    public void displayAllProducts() {
        List<Product> products = loadFromFile();
        if (products.isEmpty()) {
            System.out.println("Danh sach san pham trong.");
            return;
        }
        System.out.println("\n=== DANH SACH SAN PHAM ===");
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public void searchProductByName(String nameKeyword) {
        List<Product> products = loadFromFile();
        boolean found = false;

        System.out.println("\n--- KET QUA TIM KIEM CHO '" + nameKeyword + "' ---");
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(nameKeyword.toLowerCase())) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham nao phu hop.");
        }
    }
}