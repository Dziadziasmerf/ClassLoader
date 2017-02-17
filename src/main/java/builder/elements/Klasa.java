package builder.elements;

import factory.variables.*;
import factory.methods.*;

public class Klasa {
	public String name;
	Method_Area method_area;
	
	public Klasa(){
		name = null;
		method_area = new Method_Area();
	}
	
	public void setName(String name){
		this.name = name;
	}
	

	public void addAtr(Variable z){
		method_area.addAtr(z);
	}
	
	public void addAtrInt(IntVariable z){
		method_area.addAtr(z);
	}
	
	public void addAtrChar(CharVariable z){
		method_area.addAtr(z);
	}
	
	public void addAtrDouble(DoubleVariable z){
		method_area.addAtr(z);
	}
	
	public void addMth(Method m){
		method_area.addMth(m);
	}
	
	public Method getMethod(String name){
		return method_area.callMethod(name);
	}
	
	public void print(){
		System.out.println(name);
		method_area.print();
	}
	
}
