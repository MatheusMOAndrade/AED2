import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        /* declaração e inicialização das variáveis */
        Series seriesObj = new Series();
        String inputString;
        int seriesQtd, countFileLine = 0;

        /* objeto recebe arquivo de texto */
        TextFileRead inputFile = new TextFileRead("/tmp/data.txt");

        /* leitura do arquivo - START */
        inputFile.read();
        inputString = inputFile.read();

        while (inputString != null) {
            countFileLine++;
            inputString = inputFile.read();
        }

        inputFile.closeFile();
        /* leitura do arquivo - END */

        /* entrada de dados do arquivo - START */
        seriesQtd = countFileLine; // quantidade de séries no arquivo

        inputFile = new TextFileRead("/tmp/data.txt");
        inputFile.read();

        Series[] seriesArray = new Series[seriesQtd];

        /* entrada de dados - preenche vetor com séries */
        for (int i = 0; i < seriesQtd; i++) {
            inputString = inputFile.read();
            seriesObj.reader(seriesObj, inputString);
            seriesArray[i] = new Series(seriesObj.getName(), seriesObj.getFormat(), seriesObj.getDuration(),
                    seriesObj.getCountryOriginal(), seriesObj.getLanguageOriginal(), seriesObj.getTvChannel(),
                    seriesObj.getDateStarting(), seriesObj.getSeasonNumber(), seriesObj.getEpNumber());
        }

        inputFile.closeFile();
        /* entrada de dados do arquivo - END */

        /** Stack - START */
        Stack newStack;
        Series unstacked;
        String input;
        String seriesName;

        newStack = new Stack();

        input = sc.nextLine();

        /* entrada padrão com os nomes das séries e empilhamento das mesmas */
        while (!input.equals("FIM")) {
            for (int i = 0; i < seriesArray.length; i++) {
                if (input.equals(seriesArray[i].getName())) {

                    try {
                        newStack.stackUp(seriesArray[i]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
            input = sc.nextLine();
        }

        /* quantidade de séries que serão empilhadas */
        int qtd = sc.nextInt();
        sc.nextLine();

        /* processos de desempilhar e empilhar */
        try {
            for (int j = 0; j < qtd; j++) {

                input = sc.nextLine();

                if (input.equals("D")) {
                    unstacked = newStack.unstack();
                    System.out.print("(D) ");
                    unstacked.printName();

                } else {
                    seriesName = input.substring(2);

                    for (int k = 0; k < seriesArray.length; k++) {
                        if (seriesName.equals(seriesArray[k].getName())) {

                            newStack.stackUp(seriesArray[k]);
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        Stack inverseStack;
        inverseStack = new Stack();

        while (!newStack.emptyStack()) {
            try {
                inverseStack.stackUp(newStack.unstack());

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        try {
            inverseStack.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();

    }

    /** Stack - END */
}