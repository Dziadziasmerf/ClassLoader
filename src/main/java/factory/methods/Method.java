package factory.methods;

import java.util.*;

//import lombok.Getter;
//import lombok.Setter;

/**
 * Created by dziadziasmerf on 28.12.16.
 */

//@Getter
//@Setter
public class Method {

    public String name;
    //private Frame frame;
    private LinkedList<String> frame;

    public Method(String name, LinkedList<String> bytecode) {
        setName(name);
        //setFrame(new Frame());
        setByteCode(bytecode);
    }
    
    public void setName(String name){
    	this.name = name;
    }

    public void setByteCode(LinkedList<String> b){
    	this.frame = b;
    }
    
    //public void setFrame(Frame frame){
    //	this.frame = frame;
    //}
    
    public LinkedList<String> getFrame(){
    	return frame;
    }
    
    //public LinkedList<String> getByteCode(){
    //	return frame;
    //}


}
