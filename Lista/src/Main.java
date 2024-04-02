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

        /** List - START */

        List newList;
        Series removed, newInsertion;
        String input, seriesName;
        String[] parts;
        int position;

        newList = new List();

        input = sc.nextLine();

        /* entrada com os nomes das séries e listagem senquencial das mesmas*/
        while (!input.equals("FIM")) {
            for (int i = 0; i < seriesArray.length; i++) {

                if (input.equals(seriesArray[i].getName())) {
                    try {
                        newList.insertLast(seriesArray[i]);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
            }
            input = sc.nextLine();
        }

        /* quantidade de séries que serão inseridas ou retiradas*/
        int qtd = sc.nextInt();
        sc.nextLine();

        /* processos inserir/remover */
        try {
            for (int j = 0; j < qtd; j++) {

                input = sc.nextLine();

                if (input.equals("RI")) {
                    removed = newList.removeFirst();
                    System.out.print("(R) ");
                    removed.printName();

                } else if (input.equals("RF")) {
                    removed = newList.removeLast();
                    System.out.print("(R) ");
                    removed.printName();

                } else {
                    seriesName = input.substring(0, 2);

                    if (seriesName.equals("R*")) {
                        seriesName = input.substring(3);

                        removed = newList.remove(Integer.parseInt(seriesName));

                        System.out.print("(R) ");
                        removed.printName();

                    } else if (seriesName.equals("II")) {
                        seriesName = input.substring(3);

                        for(int i=0;i<qtd;i++) {
                            newInsertion = seriesArray[i];

                            if (seriesName.equals(seriesArray[i].getName())) {
                                newList.insertFirst(newInsertion);
                            }
                        }

                    } else if (seriesName.equals("IF")) {
                        seriesName = input.substring(3);

                        for(int i=0;i<qtd;i++){
                            newInsertion=seriesArray[i];

                            if(seriesName.equals(seriesArray[i].getName())){
                                newList.insertLast(newInsertion);

                            }
                        }

                    } else if (seriesName.equals("I*")) {

                        parts = input.split(" ", 3);

                        position = Integer.parseInt(parts[1]);
                        seriesName = parts[2];

//                            position = Integer.parseInt(input.substring(3, 5).trim());
//                            seriesName = input.substring(5).trim();

                        System.out.println("=" + position + "=");
                        System.out.println("=" + seriesName + "=");

                        for(int i = 0; i < qtd; i++){
                            newInsertion=seriesArray[i];
                            if(seriesName.equals(seriesArray[i].getName())){
                                newList.insert(newInsertion,position);
                            }
                        }
                    }
                }
            }

            /*Mostrar todas as series*/
            newList.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /** List - END */

        sc.close();


    }
}