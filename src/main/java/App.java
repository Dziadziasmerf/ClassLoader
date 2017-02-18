import interpreter.Interpreter;

import java.io.FileNotFoundException;

/**
 * Created by Jaśko on 2016-12-28.
 */
public class App {
    public static void main(String[] args){
        try {
            Interpreter interpreter = new Interpreter("mojaKlasa1");
            interpreter.read();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }


    }
}
