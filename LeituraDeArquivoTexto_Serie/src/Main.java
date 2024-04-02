import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        /*declaração e inicialização das variáveis*/
        Series seriesObj = new Series();
        String inputString;
        int seriesQtd, countFileLine = 0;

        /*objeto recebe arquivo de texto */
        TextFileRead inputFile = new TextFileRead("/tmp/data.txt");

        /*descatar cabeçalho*/
        inputFile.read();

        inputString = inputFile.read();

        while(inputString != null) {
            countFileLine++;
            inputString = inputFile.read();
        }

        inputFile.closeFile(); //fecha arquivo

        /*entrada de dados*/
        seriesQtd = countFileLine; //quantidade de séries no arquivo

        inputFile = new TextFileRead("/tmp/data.txt");

        /*descatar cabeçalho*/
        inputFile.read();

        /*vetor com as séries*/
        Series[] seriesArray = new Series[seriesQtd];

        /*entrada de dados - preenche vetor com séries*/
        for (int i = 0; i < seriesQtd; i++) {
            inputString = inputFile.read(); //entrada de dados de uma série
            seriesObj.reader(seriesObj, inputString); //split dos dados da série e definição dos atributos do objeto
            //cada posição do vetor é preenchida com um objeto
            seriesArray[i] = new Series(seriesObj.getName(), seriesObj.getFormat(), seriesObj.getDuration(), seriesObj.getCountryOriginal(), seriesObj.getLanguageOriginal(), seriesObj.getTvChannel(),seriesObj.getDateStarting(), seriesObj.getSeasonNumber(), seriesObj.getEpNumber());
        }

        inputFile.closeFile(); //fecha arquivo

        /*compara a string de entrada (nome da série) com o atributo nome do objeto no vetor das séries*/
        inputString = sc.nextLine();

        while(!inputString.equals("FIM")) {
            for (int i = 0; i < seriesArray.length; i++) {
                if (inputString.equals(seriesArray[i].getName())){
                    seriesArray[i].printer(seriesArray[i]);
                }
            }
            inputString = sc.nextLine();
        }

    }
}
