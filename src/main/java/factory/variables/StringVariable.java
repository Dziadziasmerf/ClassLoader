package factory.variables;

public class StringVariable extends Variable{
	 public StringVariable(String name) {
	        super(name);
	        this.type = VariableType.STRING;
	    }

	    public StringVariable(String name, Object value) {
	        super(name);
	        setValue(value);
	        this.type = VariableType.STRING;
	    }
}
