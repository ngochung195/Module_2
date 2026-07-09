import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountValidator {

    // 1. Chuoi Regex moi da duoc toi uu de xu ly cac truong hop bien
    private static final String EMAIL_REGEX_OPTIMIZED = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z]{2,20}$";
    private static final Pattern patternOptimized = Pattern.compile(EMAIL_REGEX_OPTIMIZED);

    public boolean validateEmailOptimized(String email) {
        if (email == null)
            return false;
        Matcher matcher = patternOptimized.matcher(email);
        return matcher.matches();
    }

    public static void main(String[] args) {
        AccountValidator validator = new AccountValidator();

        // 2. Bo ma tran du lieu kiem thu (Test Matrix) bang mang Java
        String[] validEmails = {
                "user.name@domain.com",
                "user+tag@domain.co.uk",
                "123@domain.org",
                "alex.dev+security@company.com", // Bien quai di 1
                "student@school.edu.vn", // Bien quai di 2
                "123456@domain.com", // Bien quai di 3
                "hr@company.international", // Bien quai di 4
                "support@my-domain.com" // Bien quai di 5
        };

        String[] invalidEmails = {
                "@domain.com",
                "user@.com",
                "user@domain",
                "user@domain.123",
                "user @domain.com", // Co khoang trang
                "scam@domain..com" // 2 dau cham lien tiep
        };

        // 3. Vong lap chay kiem thu va doi chieu ket qua
        System.out.println("--- KIEM THU NHOM TRUE-CASES (KY VONG: TRUE) ---");
        int passedTrue = 0;
        for (String email : validEmails) {
            boolean result = validator.validateEmailOptimized(email);
            System.out.println(email + " -> " + (result ? "PASS (True)" : "FAIL (False)"));
            if (result)
                passedTrue++;
        }

        System.out.println("\n--- KIEM THU NHOM FALSE-CASES (KY VONG: FALSE) ---");
        int passedFalse = 0;
        for (String email : invalidEmails) {
            boolean result = validator.validateEmailOptimized(email);
            System.out.println(email + " -> " + (!result ? "PASS (False)" : "FAIL (True)"));
            if (!result)
                passedFalse++;
        }

        // Tong ket chuong trinh
        System.out.println("\n--- TONG KET KIEM THU ---");
        System.out.println("Nhom True-Cases: " + passedTrue + "/" + validEmails.length);
        System.out.println("Nhom False-Cases: " + passedFalse + "/" + invalidEmails.length);
    }
}