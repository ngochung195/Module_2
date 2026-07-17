import java.util.List;

public class RandomListFacade {
    private RandomList randomList;
    private ListFilter listFilter;
    private ListPrinter listPrinter;

    public RandomListFacade() {
        this.randomList = new RandomList();
        this.listFilter = new ListFilter();
        this.listPrinter = new ListPrinter();
    }

    public void printRandomEvenList(int size, int min, int max) {
        System.out.println("--- Bắt đầu quy trình xử lý danh sách qua Facade ---");

        // 1. Tạo danh sách ngẫu nhiên ban đầu
        List<Integer> numbers = randomList.generateList(size, min, max);
        System.out.print("Danh sách ngẫu nhiên vừa tạo: ");
        listPrinter.printList(numbers);

        // 2. Lọc bỏ các phần tử lẻ, chỉ giữ lại số chẵn
        List<Integer> evenNumbers = listFilter.filterOdd(numbers);

        // 3. Hiển thị danh sách số chẵn còn lại
        System.out.print("Danh sách sau khi loại bỏ số lẻ (chỉ còn số chẵn): ");
        listPrinter.printList(evenNumbers);

        System.out.println("--- Hoàn thành quy trình ---");
    }
}