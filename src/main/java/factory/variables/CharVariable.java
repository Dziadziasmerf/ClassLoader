package factory.variables;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dziadziasmerf on 28.12.16.
 */

@Getter
@Setter
public class CharVariable extends Variable{

    private char value;

    public CharVariable(String name) {
        super(name);
    }

    public CharVariable(String name, char value) {
        super(name);
        setValue(value);
    }
}
