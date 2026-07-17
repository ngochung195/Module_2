import java.util.ArrayList;
import java.util.List;

interface SortStrategy {

    <T> void sort(List<T> items);
}

class QuickSort implements SortStrategy {

    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Quick sort");
    }
}

class MergeSort implements SortStrategy {

    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Merge sort");
    }
}

class SelectionSort implements SortStrategy {

    @Override
    public <T> void sort(List<T> items) {
        System.out.println("Selection sort");
    }
}

class SortedList {

    private SortStrategy strategy;
    private List<String> items = new ArrayList<>();

    public void setSortStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void add(String name) {
        items.add(name);
    }

    public void sort() {
        strategy.sort(items);
    }
}

public class Main {

    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.add("Java");
        sortedList.add("PHP");
        sortedList.add("C#");
        sortedList.add("Python");

        sortedList.setSortStrategy(new QuickSort());
        sortedList.sort();

        sortedList.setSortStrategy(new MergeSort());
        sortedList.sort();
    }
}