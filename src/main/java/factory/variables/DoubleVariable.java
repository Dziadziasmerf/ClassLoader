package factory.variables;

//import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

/**
 * Created by dziadziasmerf on 28.12.16.
 */
//@Getter
//@Setter
public class DoubleVariable extends Variable {

    public DoubleVariable(String name) {
        super(name);
        this.type = VariableType.DOUBLE;
    }

    public DoubleVariable(String name, Object value) {
        super(name);
        setValue(value);
        this.type = VariableType.DOUBLE;
    }

}
