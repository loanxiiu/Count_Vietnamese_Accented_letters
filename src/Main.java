import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("--Chương trình đếm số lượng các chữ cái có dấu Tiếng Việt có thể được tạo thành trong 1 chuỗi chữ cái latin nhập vào từ bàn phím--");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi:");
        String text = "";
        do {
            text = sc.nextLine().toLowerCase();
            if (!isValid(text)) {
                System.out.println("Nhập lại chuỗi (Chỉ được chứa chữ cái và chữ số):");
            }
        } while (!isValid(text));
        System.out.println("Số ký tự có dấu có thể tạo thành: " + countVietnameseAccentedLetters(text));
    }

    static int countVietnameseAccentedLetters(String text) {
        int count = 0;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                String pair = text.substring(i, i + 2);
                switch (pair) {
                    case "aw":
                    case "aa":
                    case "dd":
                    case "ee":
                    case "oo":
                    case "ow":
                        count++;
                        i++;
                        continue;
                }
            }
            if (text.charAt(i) == 'w') {
                count++;
            }
        }
        return count;
    }

    static boolean isValid(String input) {
        return input.matches("[a-zA-Z0-9]+");
    }
}