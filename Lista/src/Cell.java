public class Cell {

    private Series listSeries;
    private Cell previousCell;
    private Cell nextCell;

    /**
     * Constructors - START
     **/
    public Cell(Series newElement) {
        listSeries = newElement;
        previousCell = null;
        nextCell = null;
    }

    public Cell() {
        listSeries = new Series();
        previousCell = null;
        nextCell = null;
    }

    /**
     * Constructors - END
     **/

    public Series getListSeries() {
        return listSeries;
    }

    public void setListSeries(Series listSeries) {
        this.listSeries = listSeries;
    }

    public Cell getPreviousCell() {
        return previousCell;
    }

    public void setPreviousCell(Cell previousCell) {
        this.previousCell = previousCell;
    }

    public Cell getNextCell() {
        return nextCell;
    }

    public void setNextCell(Cell nextCell) {
        this.nextCell = nextCell;
    }
}
