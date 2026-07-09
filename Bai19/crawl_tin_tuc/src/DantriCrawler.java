import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DantriCrawler {

    public static void main(String[] args) {
        String targetUrl = "https://dantri.com.vn/the-gioi.htm";

        System.out.println("--- Dang ket noi va tai du lieu tu Dan Tri ---");

        try {
            // 1. Ket noi den URL va doc ma HTML
            URL url = new URL(targetUrl);
            URLConnection connection = url.openConnection();
            // Thiet lap User-Agent de tranh bi website chan (Gia lap trinh duyet)
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));

            StringBuilder htmlContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                htmlContent.append(line).append("\n");
            }
            reader.close();

            // 2. Chuan hoa chuoi HTML (Xoa cac khoang trang/xuong dong thua de gop dong)
            String rawHtml = htmlContent.toString().replaceAll("\\s+", " ");

            // 3. Su dung Regex de loc tieu de va link bai viet
            // Group 1: href (Link), Group 2: Tieu de
            String regex = "class=\"article-title\"[^>]*>\\s*<a[^>]*href=\"([^\"]+)\"[^>]*>(.*?)</a>";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(rawHtml);

            // 4. In danh sach ban tin ra man hinh
            System.out.println("\n--- DANH SACH BAN TIN MOI NHAT ---");
            int count = 1;
            while (matcher.find()) {
                String link = matcher.group(1);
                String title = matcher.group(2).trim();

                // Loai bo cac ky tu HTML Entity neu co (vi du: &quot;, &#39;)
                title = title.replaceAll("&quot;", "\"").replaceAll("&#39;", "'");

                // Neu link la link khuyet (relative), ta ghep them domain vao
                if (!link.startsWith("http")) {
                    link = "https://dantri.com.vn" + link;
                }

                System.out.println(count + ". " + title);
                System.out.println("   Duong dan: " + link);
                System.out.println("----------------------------------------");
                count++;
            }

        } catch (Exception e) {
            System.err.println("Da xay ra loi khi crawl du lieu: " + e.getMessage());
            e.printStackTrace();
        }
    }
}