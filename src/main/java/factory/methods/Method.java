package factory.methods;

import java.util.*;

public class Method {

    public String name;
    private LinkedList<String> frame;

    public Method(String name, LinkedList<String> bytecode) {
        setName(name);
        setByteCode(bytecode);
    }
    
    public void setName(String name){
    	this.name = name;
    }

    public void setByteCode(LinkedList<String> b){
    	this.frame = b;
    }
    
    
    public LinkedList<String> getFrame(){
    	return frame;
    }


}
