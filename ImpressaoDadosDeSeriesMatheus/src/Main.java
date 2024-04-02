import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "UTF-8");

        /*declaração e inicialização das variáveis*/
        Series seriesObj = new Series();
        String inputString;

        //entrada de dados, quantidade de séries a ser lida
        int seriesQtd = sc.nextInt();
        sc.nextLine();

        //vetor com as séries
        Series[] seriesArray = new Series[seriesQtd];

        /*preenche vetor com séries*/
        for (int i = 0; i < seriesQtd; i++) {
            inputString = sc.nextLine(); //entrada de dados de uma série
            seriesObj.reader(seriesObj, inputString); //split dos dados da série e definição dos atributos do objeto
            //cada posição do vetor é preenchida com um objeto
            seriesArray[i] = new Series(seriesObj.getName(), seriesObj.getFormat(), seriesObj.getDuration(), seriesObj.getCountryOriginal(), seriesObj.getLanguageOriginal(), seriesObj.getTvChannel(),seriesObj.getDateStarting(), seriesObj.getSeasonNumber(), seriesObj.getEpNumber());
        }

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

        sc.close();
    }
}








