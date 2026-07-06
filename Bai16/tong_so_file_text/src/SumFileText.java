import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SumFileText {
    public void readFileText(String filePath) {
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }

            bufferedReader.close();

            System.out.println("Tong = " + sum);
        } catch (Exception e) {
            System.out.println("File khong ton tai hoac noi dung co loi!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Nhap duong dan file: ");
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        SumFileText readFileEx = new SumFileText();

        readFileEx.readFileText(path);
    }
}