import java.util.Locale;
import java.util.Scanner;

public class Recursivo {

    public static int counterUpperCase(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        return (Character.isUpperCase(input.charAt(0)) ? 1 : 0) + counterUpperCase(input.substring(1));
    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String input;
        int numb;

        input = sc.nextLine();
        while (!input.equals("FIM")) {
            numb = counterUpperCase(input);
            System.out.println(numb);
            input = sc.nextLine();
        }

        sc.close();
    }
}