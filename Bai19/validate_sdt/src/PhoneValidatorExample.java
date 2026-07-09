import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PhoneExample {

    private static final String PHONE_REGEX = "^\\(\\d{2}\\)-\\(0\\d{9}\\)$";

    public PhoneExample() {
    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

public class PhoneValidatorExample {

    private static PhoneExample phoneExample;

    public static final String[] validPhone = new String[] { "(84)-(0978489648)", "(12)-(0123456789)" };
    public static final String[] invalidPhone = new String[] { "(a8)-(22222222)", "(84)-(22b22222)",
            "(84)-(9978489648)", "(84)-(012345678)" };

    public static void main(String args[]) {
        phoneExample = new PhoneExample();

        System.out.println("--- KIEM TRA CAC SO DIEN THOAI HOP LE ---");
        for (String phone : validPhone) {
            boolean isValid = phoneExample.validate(phone);
            System.out.println("So dien thoai " + phone + " hop le: " + isValid);
        }

        System.out.println("\n--- KIEM TRA CAC SO DIEN THOAI KHONG HOP LE ---");
        for (String phone : invalidPhone) {
            boolean isValid = phoneExample.validate(phone);
            System.out.println("So dien thoai " + phone + " hop le: " + isValid);
        }
    }
}