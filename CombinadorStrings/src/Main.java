import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        String inputString, splitString1, splitString2, strCombined;

        //entrada da string a ser separada
        inputString = sc.nextLine();

        while (!inputString.equals("FIM")) {

            //separa a string de entrada em duas strings
            String[] parts = inputString.split(" ");
            splitString1 = parts[0];
            splitString2 = parts[1];

            strCombined = Combiner(splitString1, splitString2);
            System.out.println(strCombined);

            inputString = sc.nextLine();
        }

        sc.close();
    }

    public static String Combiner(String splitString1, String splitString2) {

        int i, j, k;
        StringBuilder combinedString = new StringBuilder();

        //preenchimento da string combinedString intercalando até o limite do tamanho das substrings
        for (i = j = k = 0; (i < splitString1.length() && j < splitString2.length()); k++) {
            if (i <= j) {
                combinedString.append(splitString1.charAt(i));
                i++;
            } else {
                combinedString.append(splitString2.charAt(j));
                j++;
            }
        }

        //finaliza o preenchimento da string combinedString
        if (i == splitString1.length()) {
            for (k = j; k < splitString2.length(); k++) {
                combinedString.append(splitString2.charAt(j));
                j++;
            }
        } else {
            for (k = i; k < splitString1.length(); k++) {
                combinedString.append(splitString1.charAt(i));
                i++;
            }
        }

        return combinedString.toString();

    }
}