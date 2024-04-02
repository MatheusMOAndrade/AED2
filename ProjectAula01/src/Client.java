public class Client {

    private int code;
    private String name;

    /*inicialização ddos parametros das variáveis*/
    Client() {
        this.code = 0;
        this.name = "";
    }

    /*Constructor*/
    Client(int code, String name) {
        this.code = code; //THIS retorna a o código da variável da classe
        this.name = name;
    }

    /*Método GETER para atributo code*/
    public int getCode(){
        return code;
    }

    /*Método SETER para atributo code*/
    public void setCode(int code) {
        this.code = code;
    }

    /*Método GETER para atributo name*/
    public int getName(){
        return name;
    }

    /*Método SETER para atributo name*/
    public void setName(int name) {
        this.name = name;
    }
}
