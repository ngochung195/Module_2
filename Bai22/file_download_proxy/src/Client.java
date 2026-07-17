import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

interface Downloader {
    void download(String urlString, String destinationPath) throws IOException;
}

class FileDownloader implements Downloader {
    private String userAgent;

    public FileDownloader(String userAgent) {
        this.userAgent = userAgent;
    }

    @Override
    public void download(String urlString, String destinationPath) throws IOException {
        System.out.println("Connecting using User-Agent: " + this.userAgent);

        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();

        connection.setRequestProperty("User-Agent", this.userAgent);

        try (BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
                FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("Download completed successfully to: " + destinationPath);
        }
    }
}

class FileDownloaderProxy implements Downloader {
    private FileDownloader fileDownloader;

    // Định nghĩa sẵn User-Agent của Firefox để tái sử dụng
    private static final String FIREFOX_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/115.0";

    @Override
    public void download(String urlString, String destinationPath) throws IOException {
        // Lazy initialization: Chỉ khởi tạo lớp thật khi phương thức download được gọi
        if (fileDownloader == null) {
            fileDownloader = new FileDownloader(FIREFOX_USER_AGENT);
        }

        System.out.println("[Proxy] Intercepting request, forwarding to Real Downloader...");
        // Chuyển tiếp lời gọi đến đối tượng thực tế
        fileDownloader.download(urlString, destinationPath);
    }
}

public class Client {
    public static void main(String[] args) {
        // Nhúng link dẫn tới 1 file bất kỳ (ví dụ file zip, ảnh hoặc văn bản công cộng)
        String fileUrl = "https://raw.githubusercontent.com/codegym-vn/codegym-file-util/master/README.md";
        String destination = "readme_downloaded.md";

        // Sử dụng thông qua Proxy
        Downloader downloader = new FileDownloaderProxy();

        try {
            System.out.println("Starting download process via Proxy...");
            downloader.download(fileUrl, destination);
        } catch (IOException e) {
            System.err.println("Error during download: " + e.getMessage());
            e.printStackTrace();
        }
    }
}