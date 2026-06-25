import java.util.Arrays;

class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity > 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity phai lon hon 0: " + capacity);
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newSize = elements.length * 2;
            if (newSize < minCapacity) {
                newSize = minCapacity;
            }
            elements = java.util.Arrays.copyOf(elements, newSize);
        }
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        ensureCapacity(size + 1);

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public int size() {
        return this.size;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);

        elements[size++] = e;
        return true;
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}

public class MyListTest {
    public static void main(String[] args) {
        System.out.println("--- Khởi tạo danh sách ---");
        MyList<String> list = new MyList<>(5);
        System.out.println("Kích thước ban đầu: " + list.size());

        System.out.println("\n--- Thêm phần tử ---");
        list.add("Java");
        list.add("Python");
        list.add("C++");
        System.out.println("Kích thước sau khi thêm 3 phần tử: " + list.size());

        System.out.println("\n--- Lấy phần tử theo vị trí ---");
        System.out.println("Phần tử tại index 0: " + list.get(0));
        System.out.println("Phần tử tại index 2: " + list.get(2));

        System.out.println("\n--- Chèn phần tử ---");
        list.add(1, "JavaScript");
        System.out.println("Danh sách sau khi chèn 'JavaScript' vào index 1:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Index " + i + ": " + list.get(i));
        }

        System.out.println("\n--- Tìm kiếm phần tử ---");
        System.out.println("Có chứa 'Python' không? " + list.contains("Python"));
        System.out.println("Vị trí của 'Python': " + list.indexOf("Python"));
        System.out.println("Có chứa 'PHP' không? " + list.contains("PHP"));

        System.out.println("\n--- Kiểm tra tự động tăng dung lượng ---");
        list.add("Ruby");
        list.add("Go");
        list.add("Kotlin");
        System.out.println("Kích thước hiện tại sau khi thêm nhiều: " + list.size()); // Mong đợi: 7

        System.out.println("\n--- Kiểm tra lỗi (Exception) ---");
        try {
            System.out.println("Thử lấy phần tử lỗi tại index 10...");
            list.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Bắt lỗi thành công: " + e.getMessage());
        }

        System.out.println("\n--- Xóa danh sách ---");
        list.clear();
        System.out.println("Kích thước sau khi clear(): " + list.size()); // Mong đợi: 0
    }
}