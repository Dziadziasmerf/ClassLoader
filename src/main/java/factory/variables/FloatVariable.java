package factory.variables;

public class FloatVariable extends Variable{
	public FloatVariable(String name){
		super(name);
		this.type = VariableType.FLOAT;
	}

    public FloatVariable(String name, float value) {
        super(name);
        setValue(value);
    }
}
