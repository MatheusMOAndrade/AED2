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

        /*leitura do arquivo - START*/
        inputFile.read();
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

        Series[] seriesArray = new Series[seriesQtd];

        /*entrada de dados - preenche vetor com séries*/
        for (int i = 0; i < seriesQtd; i++) {
            inputString = inputFile.read();
            seriesObj.reader(seriesObj, inputString);
            seriesArray[i] = new Series(seriesObj.getName(), seriesObj.getFormat(), seriesObj.getDuration(), seriesObj.getCountryOriginal(), seriesObj.getLanguageOriginal(), seriesObj.getTvChannel(), seriesObj.getDateStarting(), seriesObj.getSeasonNumber(), seriesObj.getEpNumber());
        }

        inputFile.closeFile();
        /*entrada de dados do arquivo - END*/

        /*Queue - START*/
        Queue newQueue;
        Series dequeued;
        double avg = 0;
        String input;
        String seriesName;

        newQueue = new Queue(21);

        input = sc.nextLine();

        while (!input.equals("FIM")) {
            for (int i = 0; i < seriesArray.length; i++) {

                if (input.equals(seriesArray[i].getName())) {

                    if (newQueue.fullQueue()) {
                        try {
                            dequeued = newQueue.dequeue();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }

                    try {
                        newQueue.enqueue(seriesArray[i]);
                        avg = newQueue.seasonsAvg(seriesArray);
                        System.out.println((int) Math.round(avg));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
            input = sc.nextLine();
        }

        int qtd = sc.nextInt();
        sc.nextLine();

        avg = 0;

        try {

            for (int j = 0; j < qtd; j++) {

                input = sc.nextLine();

                if (input.equals("R")) {
                    dequeued = newQueue.dequeue();
                    System.out.print("(R) ");
                    dequeued.printName();

                } else {
                    seriesName = input.substring(2);

                    for (int k = 0; k < seriesArray.length; k++) {
                        if (seriesName.equals(seriesArray[k].getName())) {

                            if (newQueue.fullQueue()) {
                                dequeued = newQueue.dequeue();
                            }

                            newQueue.enqueue(seriesArray[k]);
                            avg = newQueue.seasonsAvg(seriesArray);
                            System.out.println((int) Math.round(avg));
                        }
                    }
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            newQueue.show(seriesObj);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close();

    }

    /*queue - END*/
}
