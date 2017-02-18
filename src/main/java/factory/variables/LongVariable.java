package factory.variables;

public class LongVariable extends Variable{
	 public LongVariable(String name) {
	        super(name);
	        this.type = VariableType.LONG;
	    }

	    public LongVariable(String name, Object value) {
	        super(name);
	        setValue(value);
	        this.type = VariableType.LONG;
	    }
}
