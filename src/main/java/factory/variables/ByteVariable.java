package factory.variables;

public class ByteVariable extends Variable{
	 public ByteVariable(String name) {
	        super(name);
	        this.type = VariableType.BYTE;
	    }

	    public ByteVariable(String name, Object value) {
	        super(name);
	        setValue(value);
	        this.type = VariableType.BYTE;
	    }
}
