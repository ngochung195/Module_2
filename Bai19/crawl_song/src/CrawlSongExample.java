import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSongExample {

    public static void main(String[] args) {
        try {
            // Bước 3: Sử dụng lớp URL để khởi tạo đường dẫn thư viện nhạc
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");

            // Mẹo bổ sung: Giả lập trình duyệt (User-Agent) để tránh bị server chặn lỗi 403
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

            // Bước 4: Mở stream và đưa nó vào InputStreamReader thông qua Scanner
            Scanner scanner = new Scanner(new InputStreamReader(connection.getInputStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();

            // Đóng scanner sau khi đọc xong
            scanner.close();

            // Bước 5: Xóa tất cả các ký tự xuống dòng (\n) trong content lấy được
            content = content.replaceAll("\\n+", "");

            // Bước 6: Lọc nội dung nằm trong tag <a> chứa class="name_song" và in ra
            System.out.println("--- DANH SÁCH BÀI HÁT CÀO ĐƯỢC ---");
            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            Matcher m = p.matcher(content);

            int count = 1;
            while (m.find()) {
                // m.group(1) sẽ lấy phần text nằm trong cặp ngoặc đơn (.*?) tức là tên bài hát
                System.out.println(count + ". " + m.group(1));
                count++;
            }

        } catch (IOException e) {
            System.err.println("Có lỗi xảy ra trong quá trình kết nối hoặc đọc dữ liệu!");
            e.printStackTrace();
        }
    }
}