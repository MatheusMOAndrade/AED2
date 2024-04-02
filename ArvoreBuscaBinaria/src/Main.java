import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

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

        /** Binary Search Tree (BST) - START */

        BST newTree = new BST();
        Series seriesObject;
        String input;

        input = sc.nextLine();

        while(!input.equals("FIM")){
            for (int i = 0; i < seriesQtd; i++){
                if(input.equals(seriesArray[i].getName())){
                    try {
                        newTree.insert(seriesArray[i]);
                    } catch (Exception erro) {
                        System.out.println(erro.getMessage());
                    }
                }
            }
            input = sc.nextLine();
        }

        input = sc.nextLine();

        while(!input.equals("FIM")) {
            seriesObject = newTree.search(input);
            if(seriesObject != null)
                System.out.println("SIM");
            else
                System.out.println("NAO");
            input = sc.nextLine();
        }

        /** Binary Search Tree (BST) */

        sc.close();
    }
}