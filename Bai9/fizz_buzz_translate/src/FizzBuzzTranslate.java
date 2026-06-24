public class FizzBuzzTranslate {

    public static String translate(int number) {
        if (number <= 0 || number >= 100) {
            throw new IllegalArgumentException("Number must be between 1 and 99");
        }

        boolean isFizz = isFizz(number);
        boolean isBuzz = isBuzz(number);

        if (isFizz && isBuzz) {
            return "FizzBuzz";
        }

        if (isFizz) {
            return "Fizz";
        }

        if (isBuzz) {
            return "Buzz";
        }

        return readNumber(number);
    }

    private static boolean isFizz(int number) {
        return number % 3 == 0 || containsDigit(number, '3');
    }

    private static boolean isBuzz(int number) {
        return number % 5 == 0 || containsDigit(number, '5');
    }

    private static boolean containsDigit(int number, char digit) {
        return String.valueOf(number).indexOf(digit) >= 0;
    }

    private static String readNumber(int number) {
        String[] words = {
                "", "một", "hai", "ba", "bốn", "năm",
                "sáu", "bảy", "tám", "chín"
        };

        if (number < 10) {
            return words[number];
        }

        int tens = number / 10;
        int ones = number % 10;

        if (ones == 0) {
            return words[tens] + " mươi";
        }

        return words[tens] + " " + words[ones];
    }
}