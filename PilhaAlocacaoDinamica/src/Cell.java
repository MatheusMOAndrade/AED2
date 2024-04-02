public class Cell {

    private Series stackSeries;
    private Cell nextCell;

    /** Constructors - START **/
    public Cell(Series newElement) {
        stackSeries = newElement;
        nextCell = null;
    }

    public Cell() {
        stackSeries = new Series();
        nextCell = null;
    }

    /** Constructors - END **/

    public Series getStackSeries() {
        return stackSeries;
    }

    public void setStackSeries(Series stackSeries) {
        this.stackSeries = stackSeries;
    }

    public Cell getNextCell() {
        return nextCell;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }
}