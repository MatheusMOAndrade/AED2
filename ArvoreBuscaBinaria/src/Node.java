public class Node {

    private Series itemSeries;
    private Node left;
    private Node right;

    /**
     * Constructors - START
     **/

    public Node(){
        itemSeries = new Series();
        left = null;
        right = null;

    }

    public Node(Series register) {
        itemSeries = register;
        left = null;
        right = null;
    }


    /**
     * Constructors - END
     **/

    /**
     * Getters and Setters - START
     **/
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Series getItemSeries() {
        return itemSeries;
    }

    public void setItemSeries(Series itemSeries) {
        this.itemSeries = itemSeries;
    }

    /**
     * Getters and Setters  - END
     **/

}