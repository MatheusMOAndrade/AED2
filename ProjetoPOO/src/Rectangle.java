public class Rectangle {

    private double base;
    private double high;

    Rectangle(double base, double high) {
        this.base = base;
        this.high = high;
    }

    //constructor square
    Rectangle(double side) {
        this.base = side;
        this.high = side;
    }

    Rectangle() {
        this.base = 0;
        this.high = 0;
    }

    //método clone
    public Rectangle clone() {
        Rectangle copy;
        copy = new Rectangle(this.base, this.high);

        return copy;
    }

    //saída de dados
    public void print() {
        System.out.println("Rectangle data:");
        System.out.println("Base: " + this.base);
        System.out.println("Higher: " + this.high);
    }

    public double getArea() {
        return this.base*this.high;
    }

    public double getPerimeter() {
        return 2*(this.base*this.high);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }
}
