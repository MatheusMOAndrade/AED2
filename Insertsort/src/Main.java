import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        /*declaração e inicialização das variáveis*/
        Series seriesObj = new Series();
        String inputString;
        int seriesQtd, countFileLine = 0;

        TextFileRead inputFile = new TextFileRead("/tmp/data.txt"); //objeto recebe arquivo de texto

        /*leitura do arquivo - START*/
        inputFile.read(); //descartar o cabeçalho
        inputString = inputFile.read();

        while (inputString != null) {
            countFileLine++;
            inputString = inputFile.read();
        }

        inputFile.closeFile();
        /*leitura do arquivo - END*/

        /*entrada de dados do arquivo - START*/
        seriesQtd = countFileLine; //quantidade de séries no arquivo

        inputFile = new TextFileRead("/tmp/data.txt");
        inputFile.read();

        Series[] seriesArray = new Series[seriesQtd]; //vetor com as séries

        /*entrada de dados - preenche vetor com séries*/
        for (int i = 0; i < seriesQtd; i++) {
            inputString = inputFile.read();
            seriesObj.reader(seriesObj, inputString);
            seriesArray[i] = new Series(seriesObj.getName(), seriesObj.getFormat(), seriesObj.getDuration(), seriesObj.getCountryOriginal(), seriesObj.getLanguageOriginal(), seriesObj.getTvChannel(), seriesObj.getDateStarting(), seriesObj.getSeasonNumber(), seriesObj.getEpNumber());
        }

        inputFile.closeFile();
        /*entrada de dados do arquivo - END*/

        /*entrada padrão com nomes das séries - START*/
        seriesQtd = sc.nextInt();
        sc.nextLine(); //limpa buffer

        Series[] sortSeriesArray = new Series[seriesQtd]; //vetor com as séries a serem ordenadas

        inputString = sc.nextLine();

        int inputCount = 0; //contagem de entradas

        while (inputCount < seriesQtd) {
            for (int i = 0; i < seriesArray.length; i++) {

                inputCount++;

                if (inputString.equals(seriesArray[i].getName())) {
                    sortSeriesArray[inputCount] = new Series(seriesArray[i].getName(), seriesArray[i].getFormat(), seriesArray[i].getDuration(), seriesArray[i].getCountryOriginal(), seriesArray[i].getLanguageOriginal(), seriesArray[i].getTvChannel(), seriesArray[i].getDateStarting(), seriesArray[i].getSeasonNumber(), seriesArray[i].getEpNumber());
                    sortSeriesArray[inputCount].printer(sortSeriesArray[inputCount]);
                }
            }
            inputString = sc.nextLine();
        }
        /*entrada padrão - END*/

        /*ordenação insertsort - START*/
        Insert insertSortObject = new Insert();

        Series[] sortMethodArray = insertSortObject.insertSort(sortSeriesArray, inputCount); //recebe o vetor ordenado

        for (int i = 0; i < seriesQtd; i++) {
            sortMethodArray[i].printer(sortMethodArray[i]); //leitura do vetor ordenado
        }
        /*ordenação insertsort - END*/

        /*Arquivo log de armazenamento - START*/
        long executionTime = System.currentTimeMillis();

        TextFileWrite writeFile = new TextFileWrite("752652_insert.txt"); //cria arquivo log

        writeFile.write("Numero de trocas entre elementos: " + insertSortObject.countSwitch + " Numero de movimentacoes no vetor " + insertSortObject.countCompare + "Matricula: xxxxx Tempo de execução em milisegundos: " + executionTime);

        writeFile.closeFile();

        /*Arquivo log de armazenamento - END*/

        sc.close();
    }
}
