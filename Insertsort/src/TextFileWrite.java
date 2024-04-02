import java.io.*;

public class TextFileWrite {

    private BufferedWriter output;

    TextFileWrite(String fileName) {

        try {
            output = new BufferedWriter(new FileWriter(fileName));
        }
        catch (FileNotFoundException exception) {
            System.out.println("File not found");
        }
        catch (IOException exception) {
            System.out.println("Opening file error " + exception);
        }
    }

    public void closeFile() {

        try {
            output.close();
        }
        catch (IOException exception) {
            System.out.println("Closure file error: " + exception);
        }
    }

    public void write(String inputText) {

        try {
            output.write(inputText);
            output.newLine();
        }
        catch (IOException exception){
            System.out.println("Input/output error " + exception);
        }
    }
}

