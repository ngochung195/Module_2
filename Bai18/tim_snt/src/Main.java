// 1. Thuật toán thô sơ (Lazy) - Duyệt từ 2 đến n-1
class LazyPrimeFactorization implements Runnable {
    @Override
    public void run() {
        long number = 2;
        while (!Thread.currentThread().isInterrupted()) {
            if (isPrime(number)) {
                System.out.println("[ Lazy Thread ] Tìm thấy số nguyên tố: " + number);
            }
            number++;
        }
    }

    private boolean isPrime(long n) {
        if (n < 2)
            return false;
        // Thuật toán kém tối ưu: Duyệt qua tất cả các số nhỏ hơn n
        for (long i = 2; i < n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

// 2. Thuật toán tối ưu (Optimized) - Chỉ duyệt đến căn bậc hai của n
class OptimizedPrimeFactorization implements Runnable {
    @Override
    public void run() {
        long number = 2;
        while (!Thread.currentThread().isInterrupted()) {
            if (isPrime(number)) {
                System.out.println(">>> [ Optimized Thread ] Tìm thấy số nguyên tố: " + number);
            }
            number++;
        }
    }

    private boolean isPrime(long n) {
        if (n < 2)
            return false;
        // Thuật toán tối ưu: Chỉ duyệt đến căn bậc hai của n (i * i <= n)
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

// 3. Lớp kiểm thử chạy đồng thời hai thuật toán
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Bắt đầu cuộc đua tìm số nguyên tố ---");

        // Khởi tạo hai đối tượng Runnable
        LazyPrimeFactorization lazyRunnable = new LazyPrimeFactorization();
        OptimizedPrimeFactorization optimizedRunnable = new OptimizedPrimeFactorization();

        // Tạo các luồng tương ứng
        Thread lazyThread = new Thread(lazyRunnable);
        Thread optimizedThread = new Thread(optimizedRunnable);

        // Kích hoạt cả hai luồng chạy song song
        lazyThread.start();
        optimizedThread.start();

        // Cho chương trình chạy trong 5 giây rồi tắt để tránh tràn console vô hạn
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n--- Dừng cuộc đua (Hết 5 giây) ---");
        lazyThread.interrupt();
        optimizedThread.interrupt();
    }
}