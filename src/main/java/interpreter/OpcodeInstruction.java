package interpreter;


/**
 * Created by Jaśko on 2016-12-28.
 */
public class OpcodeInstruction {
    public Opcode code;
    public String name;
    public int arg;

    public OpcodeInstruction(Opcode code, String name, int arg) {
        this.code = code;
        this.name = name;
        this.arg = arg;
    }
}
