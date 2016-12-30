package elements;

public class Klasa {
	public String name;
	Method_Area method_area;
	
	public void setName(String name){
		this.name = name;
	}
	
	public void addAtr(Variable z){
		method_area.addAtr(z);
	}
	
	public void addMth(Method m){
		method_area.addMth(m);
	}
	
}
