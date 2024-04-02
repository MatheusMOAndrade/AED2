public class Queue {

    private Series[] queueSeries;
    private int front;
    private int back;
    private int size;

    /**constructors - START**/
    public Queue(int size) {

        queueSeries = new Series[size];
        front = 0;
        back = 0;
        this.size = size;
    }

    public Queue() {
        queueSeries = new Series[0];
        front = 0;
        back = 0;
        this.size = 0;
    }
    /**constructors - END**/

    /*Retorna se a fila está vazia*/
    public boolean emptyQueue() {
        return (front == back ? true : false);
    }

    /*Retorna se a fila está cheia*/
    public boolean fullQueue() {
        return (((back + 1) % size) == (front % size) ? true : false);
    }


    public void enqueue(Series newElement) throws Exception {
        int position;

        if (!fullQueue()) {
            position = back % size;
            queueSeries[position] = newElement;
            back++;
        } else {
            throw new Exception("Não foi possível enfileirar o novo elemento: a fila está cheia!");
        }
    }

    public Series dequeue() throws Exception {
        Series unqueuedElement;
        int position;

        if (!emptyQueue()) {
            position = front % size;
            unqueuedElement = queueSeries[position];
            front++;
            return unqueuedElement;
        } else
            throw new Exception("Não foi possível desenfileirar nenhum elemento: a fila está vazia!");
    }

    public void show(Series sQueue) throws Exception {
        int position, count=0;

        if (! emptyQueue()) {
            for (int i = front; i < back; i++) {
                position = i % size;
                sQueue.printer(queueSeries, position, count);
                count++;
            }
        } else {
            throw new Exception("Não foi possível mostrar o conteúdo da fila: a fila está vazia!");
        }
    }

    /*Calculo da média das temporadas*/
    public double seasonsAvg(Series[] seriesObj){
        double sum = 0, avg =0, count = 0;
        int position = 0;
        for(int i = front; i < back; i++){
            position = i%size;
            sum = sum + queueSeries[position].getSeasonNumber();
            count++;
        }
        avg = sum/count;
        return avg;
    }
}