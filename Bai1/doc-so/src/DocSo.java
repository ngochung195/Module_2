import java.util.Scanner;

public class DocSo {

    public static String readOneDigit(int number) {
        switch (number) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }

    public static String readTeen(int number) {
        int ones = number % 10;
        switch (ones) {
            case 0:
                return "ten";
            case 1:
                return "eleven";
            case 2:
                return "twelve";
            case 3:
                return "thirteen";
            case 4:
                return "fourteen";
            case 5:
                return "fifteen";
            case 6:
                return "sixteen";
            case 7:
                return "seventeen";
            case 8:
                return "eighteen";
            case 9:
                return "nineteen";
            default:
                return "";
        }
    }

    // Bước 4: Hàm đọc số từ 20 đến 99
    public static String readTwoDigits(int number) {
        int tens = number / 10;
        int ones = number % 10;
        String tensStr = "";

        switch (tens) {
            case 2:
                tensStr = "twenty";
                break;
            case 3:
                tensStr = "thirty";
                break;
            case 4:
                tensStr = "forty";
                break;
            case 5:
                tensStr = "fifty";
                break;
            case 6:
                tensStr = "sixty";
                break;
            case 7:
                tensStr = "seventy";
                break;
            case 8:
                tensStr = "eighty";
                break;
            case 9:
                tensStr = "ninety";
                break;
        }

        if (ones != 0) {
            return tensStr + " " + readOneDigit(ones);
        } else {
            return tensStr;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so can doc: ");
        int number = scanner.nextInt();

        if (number < 0 || number > 999) {
            System.out.println("out of ability");
        } else if (number < 10) {
            System.out.println(readOneDigit(number));
        } else if (number < 20) {
            System.out.println(readTeen(number));
        } else if (number < 100) {
            System.out.println(readTwoDigits(number));
        } else {
            int hundreds = number / 100;
            int remainder = number % 100;

            String result = readOneDigit(hundreds) + " hundred";

            if (remainder != 0) {
                // Nếu phần còn lại nhỏ hơn 10 thì đọc là "and [số]" (VD: 205 -> two hundred and
                // five)
                if (remainder < 10) {
                    result += " and " + readOneDigit(remainder);
                }
                // Nếu phần còn lại từ 10 đến 19
                else if (remainder < 20) {
                    result += " and " + readTeen(remainder);
                }
                // Nếu phần còn lại từ 20 đến 99
                else {
                    result += " and " + readTwoDigits(remainder);
                }
            }
            System.out.println(result);
        }

        scanner.close();
    }
}