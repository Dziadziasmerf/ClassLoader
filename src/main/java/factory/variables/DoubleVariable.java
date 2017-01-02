package factory.variables;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by dziadziasmerf on 28.12.16.
 */
@Getter
@Setter
public class DoubleVariable extends Variable {

    private double value;

    public DoubleVariable(String name) {
        super(name);
    }

    public DoubleVariable(String name, double value) {
        super(name);
        setValue(value);
    }

}
