package interpreter;

import builder.building.Builder;
import builder.elements.Klasa;
import builder.executor.Executor;
import builder.memory.Memory;
import factory.Factory;
import factory.methods.Method;
import factory.variables.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * Interpreter of given bytecode
 */
public class Interpreter {
    private static final Logger LOGGER = Logger.getLogger(Interpreter.class.getName());
    Builder builder;
    Memory memory;
    private final String classname;
    private String currentMethod;
    private LinkedList<String> methodBytecode;

    public Interpreter(String classname) {
        this.builder = new Builder(new Factory());
        this.memory = Memory.getInstance();
        this.classname = classname;
        this.currentMethod = null;
        this.methodBytecode = new LinkedList<String>();
    }

    public void read() throws FileNotFoundException{
        try {
            BufferedReader br = new BufferedReader(new FileReader("bytecodes/" + this.classname + ".txt"));
            try {
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
            throw e;
        }
    }

    private void interprete(String bytecodeLine) {
        String[] parts = bytecodeLine.split(" ");

        if(this.currentMethod != null){

            if(parts[0].equals("end " + this.currentMethod)){
                builder.buildMethod(this.currentMethod, this.methodBytecode);
                this.currentMethod = null;
                this.methodBytecode = null;
            }else{
                methodBytecode.add(bytecodeLine);
            }

        }else{

            if (parts[0].equals("init")) {
                if(!builder.checkClassLoader(parts[1], memory)){
                    builder.buildClass();
                    if (parts[1] != null) builder.buildName(parts[1]);
                }
            } else if (parts[0].equals("i")) {
                builder.buildAtribute(parts[1], VariableType.INT, Integer.valueOf(parts[2]));
            } else if (parts[0].equals("d")) {
                builder.buildAtribute(parts[1], VariableType.DOUBLE, Double.valueOf(parts[2]));
            } else if (parts[0].equals("c")) {
                builder.buildAtribute(parts[1], VariableType.CHAR, parts[2].charAt(0));
            } else if (parts[0].equals("f")) {
                builder.buildAtribute(parts[1], VariableType.FLOAT, Float.valueOf(parts[2]));
            } else if (parts[0].equals("b")) {
                builder.buildAtribute(parts[1], VariableType.BYTE, Byte.valueOf(parts[2]));
            } else if (parts[0].equals("l")) {
                builder.buildAtribute(parts[1], VariableType.LONG, Long.valueOf(parts[2]));
            } else if (parts[0].equals("s")) {
                builder.buildAtribute(parts[1], VariableType.STRING, parts[2]);
            } else if (parts[0].equals("met")) {
                this.currentMethod = parts[1];
            } else if (parts[0].equals("end")) {
                builder.printClass();
                builder.toMemory(memory);
            } else {
                Interpreter innerInterpreter = new Interpreter(parts[0]);
                try{
                    innerInterpreter.read();
                    builder.addClass(innerInterpreter.memory.find(parts[0]), parts[1]);
                }catch(FileNotFoundException e){
                    LOGGER.info("<<ERROR>> Klasa składowa " + parts[0] + " klasy " + this.classname + " nie została odnaleziona !!!");
                }
            }

        }
    }

    public static void interpreteMethod(Method method, Klasa klasa){
        Executor executor = new Executor(Memory.getInstance(),klasa);
        for(String line: method.getFrame()){
            String[] parts = line.split(" ");
            if(parts.length == 1){
                if(parts[0].equals("add")){
                    executor.add();
                } else if (parts[0].equals("sub")){
                    executor.sub();
                } else if (parts[0].equals("mull")){
                    executor.mull();
                } else if (parts[0].equals("div")){
                    executor.div();
                } else if(parts[0].equals("pop")){
                    Variable v = executor.pop();
                } else if(parts[0].equals("ret")){
                    Variable v = executor.ret();
                } else {
                    LOGGER.info("Unrecognized bytecode command");
                }
            } else{
                if (parts[0].equals("i")) {
                    Variable v = new IntVariable(null,Integer.valueOf(parts[1]));
                    executor.push(v);
                } else if(parts[0].equals("d")){
                    Variable v = new DoubleVariable(null,Double.valueOf(parts[1]));
                    executor.push(v);
                } else if(parts[0].equals("c")){
                    Variable v = new CharVariable(null, parts[1].charAt(0));
                    executor.push(v);
                } else if(parts[0].equals("f")){
                    Variable v = new FloatVariable(null, Float.valueOf(parts[1]));
                    executor.push(v);
                } else if(parts[0].equals("l")){
                    Variable v = new LongVariable(null, Long.valueOf(parts[1]));
                    executor.push(v);
                } else if(parts[0].equals("s")){
                    Variable v = new StringVariable(null, parts[1]);
                    executor.push(v);
                } else if(parts[0].equals("b")){
                    Variable v = new ByteVariable(null, Byte.valueOf(parts[1]));
                    executor.push(v);
                } else{
                    LOGGER.info("Unrecognized bytecode command");
                }
            }
        }
    }
}
