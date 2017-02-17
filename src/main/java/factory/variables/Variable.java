package factory.variables;

/**
 * Created by dziadziasmerf on 28.12.16.
 */
public abstract class Variable {
    public String name;
    protected VariableType type;
    protected Object value;

    public Variable(String name) {
        this.name = name;
    }
    
    public VariableType getType(){
    	return type;
    }
    
    public Object getValue(){
    	return value;
    }
    
    public void setValue(Object value){
    	this.value = value;
    }

}
