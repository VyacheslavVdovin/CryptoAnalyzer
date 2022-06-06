import java.util.*;

public class CryptoAnalyzer {
    private static final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";

//Метод шифрования текста:
    public static String encrypt(String text, int key) {
        text = text.toLowerCase();
        String cipherText ="";
        for (int i = 0; i < text.length(); i++) {
            int charPosition = alphabet.indexOf(text.charAt(i));
            int keyIndex = (key + charPosition) % 41;
            char replaceIndex = alphabet.charAt(keyIndex);
            cipherText += replaceIndex;
        }
        return cipherText;
    }

//Метод расшифровки текста:
    public static String decrypt(String cipherText, int shiftKey) {
        cipherText = cipherText.toLowerCase();
        String message = "";
        for (int i = 0; i < cipherText.length(); i++) {
            int charPosition = alphabet.indexOf(cipherText.charAt(i));
            int keyIndex = (charPosition - shiftKey) % 41;
            if (keyIndex < 0) {
                keyIndex = alphabet.length() + keyIndex;
            }
            char replaceIndex = alphabet.charAt(keyIndex);
            message += replaceIndex;
        }
        return message;
    }

//Метод BruteForce:
    public static String bruteForce(String cipherText) {
        cipherText = cipherText.toLowerCase();
        String message = "";
        for (int i = 0; i < cipherText.length(); i++) {
            for (int j = 0; j <= 41; j++) {
                int charPosition = alphabet.indexOf(cipherText.charAt(i));
                int keyIndex = (charPosition - j) % 41;
                if (keyIndex < 0) {
                    keyIndex = alphabet.length() + keyIndex;
                }
                char replaceIndex = alphabet.charAt(keyIndex);
                message += replaceIndex;
            }
        }
        return message;
    }


    public static void main(String[] args) {
        System.out.println("Воспользуйтесь криптоанализатором который использует шифр Цезаря!!!");
        System.out.println("Введите номер пункта, для выбора команды:");
        System.out.println("1. Зашифровать текст");
        System.out.println("2. Расшифровать текст");
        System.out.println("3. Расшифровка методом BruteForce");

        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        scanner.useDelimiter("\n");
        while (command != 0) {
            if (command == 1) {
                System.out.println("Введите текст который нужно зашифровать:");
                String text = scanner.next();
                System.out.println("Введите ключ для шифровки:");
                int key = scanner.nextInt();
                System.out.println(encrypt(text, key));
                break;
            } else if (command == 2) {
                System.out.println("Введите текст который нужно расшифровать:");
                String cipherText = scanner.next();
                System.out.println("Введите ключ для расшифровки:");
                int shiftKey = scanner.nextInt();
                System.out.println(decrypt(cipherText, shiftKey));
                break;
            } else if (command == 3) {
                System.out.println("Введите текст который нужно расшифровать:");
                String cipherText = scanner.next();
                System.out.println("Ваш расшифрованный код:");
                System.out.println(bruteForce(cipherText));
                break;
            } else {
                break;
            }
        }
    }
}
