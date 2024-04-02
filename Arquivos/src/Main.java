import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "UTF-8");
        ArquivoTextoEscrita arqEscrita;
        ArquivoTextoLeitura arqEntrada;
        String nomeArq, textoDeEntrada;

        System.out.println("Informe o nome do arquivo: ");
        nomeArq = sc.nextLine();

        arqEscrita = new ArquivoTextoEscrita(nomeArq); //"/temp/data.txt"

        System.out.println("Informe o texto a ser gravado: ");
        System.out.println("Digite SAIR para finalizar: ");

        textoDeEntrada = sc.nextLine();
        while (!textoDeEntrada.equals("SAIR")) {
            arqEscrita.escrever(textoDeEntrada);
            textoDeEntrada = sc.nextLine();
        }

        arqEscrita.fecharArquivo();

        arqEntrada = new ArquivoTextoLeitura(nomeArq);

        textoDeEntrada = arqEntrada.ler();
        while (textoDeEntrada != null) {
            System.out.println(textoDeEntrada);
            textoDeEntrada = arqEntrada.ler();
        }

        arqEntrada.fecharArquivo();

        sc.close();
    }
}
