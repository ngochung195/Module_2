import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ClassNameExample {
    private static final String CLASS_NAME_REGEX = "^[CAP]\\d{4}[GHIK]$";

    public ClassNameExample() {

    }

    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}

public class ClassValidatorExample {
    private static ClassNameExample classNameExample;

    public static final String[] validClass = new String[] { "C0223G", "A0323K", "P1234H", "C9999I" };
    public static final String[] invalidClass = new String[] { "M0318G", "P0323A", "C123G", "C12345G", "A123@G" };

    public static void main(String[] args) {
        classNameExample = new ClassNameExample();

        System.out.println("KIEM TRA TEN LOP HOP LE");
        for (String className : validClass) {
            boolean isValid = classNameExample.validate(className);
            System.out.println("Ten lop " + className + " hop le: " + isValid);
        }

        System.out.println("KIEM TRA TEN LOP KHONG HOP LE");
        for (String className : invalidClass) {
            boolean isValid = classNameExample.validate(className);
            System.out.println("Ten lop " + className + " hop le: " + isValid);
        }
    }
}