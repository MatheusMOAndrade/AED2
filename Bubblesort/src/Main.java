import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        /*declaração e inicialização das variáveis*/
        Series seriesObj = new Series();
        String inputString,writeString;
        int seriesQtd, countFileLine = 0;

        /*objeto recebe arquivo de texto */
        TextFileRead inputFile = new TextFileRead("\"/tmp/data.txt\"");

        /*leitura do arquivo - START*/
        inputFile.read();

        inputString = inputFile.read();

        while(inputString != null) {
            countFileLine++;
            inputString = inputFile.read();
        }

        inputFile.closeFile();
        /*leitura do arquivo - END*/

        /*entrada de dados do arquivo - START*/
        seriesQtd = countFileLine; //quantidade de séries no arquivo

        inputFile = new TextFileRead("\"/tmp/data.txt\"");
        inputFile.read();

        Series[] seriesArray = new Series[seriesQtd];

        /*entrada de dados - preenche vetor com séries*/
        for (int i = 0; i < seriesQtd; i++) {
            inputString = inputFile.read();
            seriesObj.reader(seriesObj, inputString);
            seriesArray[i] = new Series(seriesObj.getName(), seriesObj.getFormat(), seriesObj.getDuration(), seriesObj.getCountryOriginal(), seriesObj.getLanguageOriginal(), seriesObj.getTvChannel(),seriesObj.getDateStarting(), seriesObj.getSeasonNumber(), seriesObj.getEpNumber());
        }

        inputFile.closeFile();
        /*entrada de dados do arquivo - END*/

        /*entrada padrão com nomes das séries - START*/
        int inputCount = 0;

        seriesQtd = sc.nextInt();

        sc.nextLine();

        Series[] sortSeriesArray = new Series[seriesQtd];

        inputString = sc.nextLine();

        while(inputCount < seriesQtd) {
            for (int i = 0; i < seriesArray.length; i++) {
                if (inputString.equals(seriesArray[i].getName())){
                    sortSeriesArray[inputCount] = new Series(seriesArray[i].getName(), seriesArray[i].getFormat(), seriesArray[i].getDuration(), seriesArray[i].getCountryOriginal(), seriesArray[i].getLanguageOriginal(), seriesArray[i].getTvChannel(),seriesArray[i].getDateStarting(), seriesArray[i].getSeasonNumber(), seriesArray[i].getEpNumber());
                    sortSeriesArray[inputCount].printer(sortSeriesArray[inputCount]);
                }
            }
            inputCount++;

            if(inputCount<seriesQtd){
                inputString = sc.nextLine();
            }
        }
        /*entrada padrão - END*/

        /*ordenação bubblesort - START*/
        Bubblesort bubbleSortSeries = new Bubblesort();

        Series[] sortMethodArray = bubbleSortSeries.sortArray(sortSeriesArray,seriesQtd);

        for(int i = 0; i < seriesQtd; i++){
            sortMethodArray[i].printer(sortMethodArray[i]);
        }
        /*ordenação bubblesort - END*/

        /*Arquivo log de armazenamento - START*/
        long executionTime = System.currentTimeMillis();

        TextFileWrite writeFile = new TextFileWrite("752652_bubble.txt");

        writeFile.write("Numero de trocas entre elementos: " + bubbleSortSeries.countSwitch + " Numero de movimentacoes no vetor " + bubbleSortSeries.countCompare + "Matricula: xxxxx Tempo de execução em milisegundos: " + executionTime);

        writeFile.closeFile();
        /*Arquivo log de armazenamento - END*/

        sc.close();
    }
}
