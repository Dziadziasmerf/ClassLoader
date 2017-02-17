package factory;

import factory.methods.Method;
import factory.variables.*;
import java.util.*;

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
            case FLOAT:
                return  new FloatVariable(name);
            case STRING:
                return  new StringVariable(name);
            case BYTE:
                return  new ByteVariable(name);
            default:
                return null;
        }
    }

    public Method createMethod(String name, LinkedList<String> bytecode) {
        return new Method(name, bytecode);
    }
}
