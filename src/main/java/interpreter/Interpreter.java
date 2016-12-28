package interpreter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Interpreter of given bytecode
 */
public class Interpreter {

    private static class InterpreterHelper{
        private static Interpreter instance = new Interpreter();
    }

    public static Interpreter getInstance(){
        return InterpreterHelper.instance;
    }

    public void read(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("bytecode.txt"));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    String[] result = line.split(" ");
                    //result[0] is opcode
                    //result[1] is variable name;
                    //result[2] is argument (or null)
                    // WYWOLANIE METODY Z BUILDERA

                    line = br.readLine();
                }
            } catch(IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        } catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
