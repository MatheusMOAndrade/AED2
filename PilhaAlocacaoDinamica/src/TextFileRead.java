    import java.io.*;

    public class TextFileRead {

        private BufferedReader input;

        TextFileRead(String fileName) {

            try {
                input = new BufferedReader(new FileReader(fileName));
            }
            catch (FileNotFoundException exception) {
                System.out.println("File not found");
            }
        }

        public void closeFile() {

            try {
                input.close();
            }
            catch (IOException exception) {
                System.out.println("Closure file error: " + exception);
            }
        }

        public String read() {

            String inputText = null;

            try {
                inputText = input.readLine();
            }
            catch (EOFException exception) {
                inputText = null;
            }
            catch (IOException exception) {
                System.out.println("Reading error: " + exception);
                inputText = null;
            }
            finally {
                return inputText;
            }
        }
    }

