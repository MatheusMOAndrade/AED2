import java.util.Locale;

public class Main {

    //uso do throws não obriga o tratamento
    public static void method(int i) throws Exception {

        if((i % 2) == 0)
        {
            System.out.println(i + "é par.");
        } else {
            throw new Exception("Number is odd.");
        }
    }

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        try {
            method(2);
        } catch(Exception exception){
            System.out.println(exception.getMessage());
        }

//        int i;
//
//        try {
//            i = Integer.parseInt(args[0]);
//            System.out.println("i value: " + i);
//        } catch(NumberFormatException exception){
//            System.out.println("N/A: insert a integer.");
//        } catch (ArrayIndexOutOfBoundsException exception) {
//            System.out.println("N/A: insert a integer.");
//        } catch (Exception exception) {
//            System.out.println("N/A: invalid inserted data.");
//        }

    }
}
