public class Stack {

    private Series[] stackSeries;
    private int top;
    private int size;

    /**Constructors - Start*/
    public Stack() {
        stackSeries = new Series[0];
        top = 0;
        this.size = 0;
    }

    public Stack(int size) {
        stackSeries = new Series[size];
        top = 0;
        this.size = size;
    }
    /** Constructors - End*/

    /*Retorna se a pilha está vazia*/
    public boolean emptyStack() {
        return (top == 0 ? true : false);
    }

    /*Retorna se a pilha está cheia*/
    public boolean fullStack() {
        return (top == stackSeries.length ? true : false);
    }

    /*método de empilhamento LIFO*/
    public void stackUp(Series newElement) {
        if (!fullStack()) {
            stackSeries[top] = newElement;
            top++;
        }
    }

    /*método de desempilhar LIFO*/
    public Series unstack() throws Exception {
        Series unstacked;

        if (!emptyStack()) {
            top--;
            unstacked = stackSeries[top];
            return unstacked;
        } else {
            throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
        }
    }

    /*método mostrar LIFO*/
    public Series show() throws Exception {

        if (!emptyStack()) {
            return (stackSeries[top - 1]);
        } else {
            throw new Exception("Não foi possível consultar o elemento do topo da pilha: a pilha está vazia!");
        }
    }


}
