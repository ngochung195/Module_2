import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Class đại diện cho đối tượng Quốc gia
class Country {
    private int id;
    private String code;
    private String name;

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Country [ID=" + id + ", Code=" + code + ", Name=" + name + "]";
    }
}

public class ReadCSVExample {
    public static void main(String[] args) {
        String filePath = "countries.csv"; // Tên file CSV đầu vào
        List<Country> countryList = new ArrayList<>();

        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("Lỗi: File " + filePath + " không tồn tại!");
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            // Đọc từng dòng của file CSV
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue; // Bỏ qua nếu dòng trống
                }

                // Sử dụng split() để cắt chuỗi tại vị trí dấu phẩy
                String[] data = line.split(",");

                if (data.length == 3) {
                    // Lấy dữ liệu và loại bỏ dấu ngoặc kép thừa bằng cách dùng replaceAll
                    int id = Integer.parseInt(data[0].trim());
                    String code = data[1].trim().replaceAll("\"", "");
                    String name = data[2].trim().replaceAll("\"", "");

                    // Tạo đối tượng Country và thêm vào danh sách
                    Country country = new Country(id, code, name);
                    countryList.add(country);
                }
            }
            br.close(); // Đóng luồng đọc file

            // Hiển thị danh sách các quốc gia đã đọc được
            System.out.println("--- DANH SÁCH CÁC QUỐC GIA ĐỌC TỪ FILE CSV ---");
            for (Country c : countryList) {
                System.out.println(c);
            }

        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi định dạng số ID trong file: " + e.getMessage());
        }
    }
}