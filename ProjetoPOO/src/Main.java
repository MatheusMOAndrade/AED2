import java.lang.annotation.Retention;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        Rectangle myRectangle, mySquare, copy;

        myRectangle = new Rectangle(3.0, 4.0);
        mySquare = new Rectangle(2.0);

        copy = myRectangle.clone();
        copy.print();

        System.out.println("My rectangle area: " + myRectangle.getArea());
        System.out.println("My square perimeter: " + mySquare.getPerimeter());

    }
}
