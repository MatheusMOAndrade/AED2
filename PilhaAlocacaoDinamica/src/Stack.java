public class Stack {

    private Cell bottom;
    private Cell top;

    /** Constructors - Start */
    public Stack() {
        Cell sentinel;

        sentinel = new Cell();
        bottom = sentinel;
        top = sentinel;
    }

    /** Constructors - End */

    /* Retorna se a pilha está vazia */
    public boolean emptyStack() {
        boolean resp;
        if (top == bottom) {
            resp = true;
        } else
            resp = false;
        return resp;
    }

    /* método de empilhamento LIFO */
    public void stackUp(Series newElement) {
        Cell newCell = new Cell(newElement);

        newCell.setNextCell(top);
        top = newCell;
    }

    /* método de desempilhar LIFO */
    public Series unstack() throws Exception {

        Cell unstacked;

        if (!emptyStack()) {
            unstacked = top;
            top = top.getNextCell();
            unstacked.setNextCell(null);
            return (unstacked.getStackSeries());
        } else {
            throw new Exception("Não foi possível desempilhar: a pilha está vazia!");
        }
    }

    /* método mostrar LIFO */
    public void show() throws Exception {
        Cell aux;
        int count = 0;

        if (!emptyStack()) {
            aux = top;

            while ((aux != null) && (aux != bottom)) {
                aux.getStackSeries().printer(count);
                aux = aux.getNextCell();
                count++;
            }

        } else {
            throw new Exception("Não foi possível consultar o elemento do topo da pilha: a pilha está vazia!");
        }
    }
}