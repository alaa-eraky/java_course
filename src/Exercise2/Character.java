package Exercise2;

import java.util.Scanner;

public class Character {
    interface StringUtils {
        boolean isLetter(String word);
    }

    public static void main(String[] args) {
        String word;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        word = scanner.nextLine();
        StringUtils stringUtils = (w) -> ((w != null) && (!w.equals("")) && (w.matches("^[a-zA-Z]*$")));
        if (stringUtils.isLetter(word)) {
            System.out.println("The word has only alphabets");
        } else {
            System.out.println("The word has alphabets and others");
        }
    }
}