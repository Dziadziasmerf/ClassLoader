package factory.variables;

public class CharVariable extends Variable{

    public CharVariable(String name) {
        super(name);
        this.type = VariableType.CHAR;
    }

    public CharVariable(String name, Object value) {
        super(name);
        setValue(value);
        this.type = VariableType.CHAR;
    }

}
