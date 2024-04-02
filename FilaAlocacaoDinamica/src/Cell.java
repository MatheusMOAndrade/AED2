public class Cell {

    private Series queueSeries;
    private Cell nextCell;

    /**Constructors - START**/
    public Cell(Series newElement) {
        queueSeries = newElement;
        nextCell = null;
    }

    public Cell() {
        queueSeries = new Series();
        nextCell = null;
    }
    /**Constructors - END**/

    public Series getQueueSeries() {
        return queueSeries;
    }

    public void setQueueSeries(Series queueSeries) {
        this.queueSeries = queueSeries;
    }

    public Cell getNextCell() { return nextCell; }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }
}
