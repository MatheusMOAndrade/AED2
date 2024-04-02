import java.util.Locale;
import java.util.Scanner;

public class Iterativo {

    public static int counterUpperCase(String input) {

        int numbUpperCase = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                numbUpperCase++;
            }
        }

        return numbUpperCase;
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


