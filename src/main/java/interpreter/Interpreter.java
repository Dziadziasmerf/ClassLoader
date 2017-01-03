package interpreter;

import builder.building.Builder;
import builder.memory.Memory;
import factory.Factory;
import factory.variables.VariableType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Interpreter of given bytecode
 */
public class Interpreter {
    private static final Logger LOGGER = Logger.getLogger(Interpreter.class.getName());
    Builder builder;
    Memory memory;

    private Interpreter() {
        this.builder = new Builder(new Factory());
        this.memory = new Memory();
    }

    public static Interpreter getInstance() {
        return InterpreterHelper.instance;
    }

    public void read() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("bytecode.txt"));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    interprete(line);

                    line = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void interprete(String bytecodeLine) {
        String[] parts = bytecodeLine.split(" ");

        if (parts[0].equals("init")) {
            builder.buildClass();
            if (parts[1] != null) builder.buildName(parts[1]);
        } else if (parts[0].equals("i")) {
            builder.buildAtribute(parts[1], VariableType.INT, Integer.valueOf(parts[2]));
        } else if (parts[0].equals("d")) {
            builder.buildAtribute(parts[1], VariableType.DOUBLE, Double.valueOf(parts[2]));
        } else if (parts[0].equals("c")) {
            builder.buildAtribute(parts[1], VariableType.CHAR, parts[2].charAt(0));
        } else if (parts[0].equals("met_i")) {
            builder.buildMethod(parts[1]);
        } else if (parts[0].equals("met_d")) {
            builder.buildMethod(parts[1]);
        } else if (parts[0].equals("met_c")) {
            builder.buildMethod(parts[1]);
        } else if (parts[0].equals("end")) {
            builder.printClass();
            builder.toMemory(memory);
        } else {
            LOGGER.info("Unrecognized bytecode sentence");
        }
    }

    private static class InterpreterHelper {
        private static Interpreter instance = new Interpreter();
    }
}
