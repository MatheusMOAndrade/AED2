public class Student {

    private int regNumber;
    private char[] studentAnswers;

    /*Contructor*/
    Student(int regNumber, char[] studentAnswers)
    {
        this.regNumber = regNumber;
        this.studentAnswers = studentAnswers;
    }

    public int getRegNumber() {
        return regNumber;
    }
}
