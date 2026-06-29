import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Record {
    String name;
    String gender; // "Nu" hoặc "Nam"

    public Record(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ")";
    }
}

public class DemergingAlgorithm {
    public static void main(String[] args) {
        List<Record> inputList = new ArrayList<>();
        inputList.add(new Record("Nguyễn Văn A", "Nam"));
        inputList.add(new Record("Trần Thị B", "Nu"));
        inputList.add(new Record("Lê Văn C", "Nam"));
        inputList.add(new Record("Phạm Thùy D", "Nu"));
        inputList.add(new Record("Hoàng Thị E", "Nu"));
        inputList.add(new Record("Đỗ Minh F", "Nam"));

        System.out.println("Dữ liệu ban đầu:");
        inputList.forEach(System.out::println);

        Queue<Record> NU = new LinkedList<>();
        Queue<Record> NAM = new LinkedList<>();

        for (Record p : inputList) {
            if (p.gender.equalsIgnoreCase("Nu")) {
                NU.add(p);
            } else if (p.gender.equalsIgnoreCase("Nam")) {
                NAM.add(p);
            }
        }

        List<Record> outputFile = new ArrayList<>();

        while (!NU.isEmpty()) {
            Record p = NU.poll();
            outputFile.add(p);
        }

        while (!NAM.isEmpty()) {
            Record p = NAM.poll();
            outputFile.add(p);
        }

        System.out.println("\n--- Kết quả sau khi chạy giải thuật Demerging (Nữ trước, Nam sau) ---");
        for (Record r : outputFile) {
            System.out.println(r);
        }
    }
}