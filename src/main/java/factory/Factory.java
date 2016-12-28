package factory;

import factory.methods.Method;
import factory.variables.*;

/**
 * Created by dziadziasmerf on 27.12.16.
 */
public class Factory {

    public Variable createVariable(String name, VariableType type) {
        switch(type) {
            case INT:
                return new IntVariable(name);
            case CHAR:
                return new CharVariable(name);
            case DOUBLE:
                return  new DoubleVariable(name);
            default:
                return null;
        }
    }

    public Method createMethod(String name) {
        return new Method(name);
    }
}
