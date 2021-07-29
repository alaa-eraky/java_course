package Exercise2;

import java.util.Scanner;

public class BetterString {

    interface Better {
        String betterString(String s1, String s2);
    }

    public static void main(String[] args) {
        String string1;
        String string2;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        string1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        string2 = scanner.nextLine();

        Better better = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;
        System.out.println("The better String is: " + better.betterString(string1, string2));
    }
}
