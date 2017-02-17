package factory.variables;

public class FloatVariable extends Variable{
	public FloatVariable(String name){
		super(name);
		this.type = VariableType.FLOAT;
	}

    public FloatVariable(String name, Object value) {
        super(name);
        setValue(value);
    }
}
