package factory.variables;

public class IntVariable extends Variable {

    public IntVariable(String name) {
        super(name);
        this.type = VariableType.INT;
    }

    public IntVariable(String name, int value) {
        super(name);
        setValue(value);
    }

}
