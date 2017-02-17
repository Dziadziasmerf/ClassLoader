package factory.variables;

//import lombok.Getter;
//import lombok.Setter;

/**
 * Created by dziadziasmerf on 28.12.16.
 */

//@Getter
//@Setter
public class CharVariable extends Variable{

    public CharVariable(String name) {
        super(name);
        this.type = VariableType.CHAR;
    }

    public CharVariable(String name, Object value) {
        super(name);
        setValue(value);
    }

}
