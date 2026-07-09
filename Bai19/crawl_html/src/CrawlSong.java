import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSong {
    public static void main(String[] args) {
        try {
            // 1. Đọc nội dung HTML từ file với định dạng UTF-8 để tránh lỗi font tiếng Việt
            String content = new String(Files.readAllBytes(Paths.get("songs.html")), StandardCharsets.UTF_8);

            // 2. Xóa tất cả các ký tự xuống dòng (cả \r và \n)
            content = content.replaceAll("[\\r\\n]+", "");

            // 3. Regex lọc tên bài hát dựa trên class="name_song"
            Pattern pattern = Pattern.compile("class=\"name_song\"[^>]*>(.*?)</a>");
            Matcher matcher = pattern.matcher(content);

            // 4. In danh sách bài hát ra màn hình
            System.out.println("--- DANH SÁCH BÀI HÁT TÌM THẤY ---");
            int count = 1;
            while (matcher.find()) {
                // matcher.group(1) lấy nội dung bên trong cặp thẻ <a> (group đầu tiên trong dấu
                // ngoặc đơn)
                System.out.println(count + ". " + matcher.group(1).trim());
                count++;
            }

        } catch (IOException e) {
            System.err.println("Lỗi: Không tìm thấy file 'songs.html' hoặc file bị lỗi!");
            e.printStackTrace();
        }
    }
}