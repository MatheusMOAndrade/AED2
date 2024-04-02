public class Queue {

    private Cell front;
    private Cell back;
    private int size;

    public Queue() { //cria celula sentinela
        Cell sentinel;

        sentinel = new Cell();
        front = sentinel;
        back = sentinel;
    }

    /*Retorna se a fila está vazia*/
    public boolean emptyQueue() {
        return (front == back ? true : false);
    }

    public void enqueue(Series newElement) { //enfileiramento

        Cell newCell = new Cell(newElement);

        back.setNextCell(newCell);
        back = newCell;
    }

    public Series dequeue() throws Exception {

        Cell unqueuedCell;
        Cell nexCell;

        if (!emptyQueue()) {
            unqueuedCell = front.getNextCell();
            nexCell = unqueuedCell.getNextCell();
            front.setNextCell(nexCell);

            if (unqueuedCell == back) {
                back = front;
            }
            return (unqueuedCell.getQueueSeries());

        } else {
            throw new Exception("Não foi possível desenfileirar nenhum item: a fila está vazia!");
        }
    }

    public void show() throws Exception {
        Cell aux;
        int count=0;

        if (! emptyQueue()) {

            aux = front.getNextCell();

            while (aux != null) {
                aux.getQueueSeries().printer(count);
                count++;
                aux = front.getNextCell();
            }

        } else {
            throw new Exception("Não foi possível mostrar o conteúdo da fila: a fila está vazia!");
        }
    }

    /*Calculo da média das temporadas*/
    public double seasonsAvg(){
        Cell aux;
        double sum = 0, avg = 0, count = 0;

        aux = front.getNextCell();

        while (aux != null){
            sum = sum + aux.getQueueSeries().getSeasonNumber();
            count++;
        }

        avg = sum/count;
        return avg;
    }
}
