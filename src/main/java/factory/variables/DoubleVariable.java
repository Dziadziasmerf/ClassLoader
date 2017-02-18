package factory.variables;

public class DoubleVariable extends Variable {

    public DoubleVariable(String name) {
        super(name);
        this.type = VariableType.DOUBLE;
    }

    public DoubleVariable(String name, Object value) {
        super(name);
        setValue(value);
    }

}
