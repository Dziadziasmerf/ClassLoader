package builder.executor;

import builder.memory.*;
import builder.elements.*;
import factory.methods.*;
import factory.variables.*;
import factory.*;
import builder.building.*;

public class Executor {
	Memory memory;
	private Factory f;
	private ReadVar reader;
	private Klasa klasa = null;
	private Builder builder;
	
	public Executor(Memory m, Klasa k){
		this.memory = m;
		reader = new ReadVar();
		this.klasa = k;
		this.f = new Factory();
		this.builder = new Builder(f);
	}
	
	public void changeKlasa(Klasa k){
		this.klasa = k;
	}
	
	private VariableType learnTypes(Variable v1, Variable v2){
		if(v1.getType() != v2.getType()){
			return null;
		}else{
			VariableType t = v1.getType();
			switch(t){
				case INT: return VariableType.INT;
				case CHAR: return VariableType.CHAR;
				case DOUBLE: return VariableType.DOUBLE;//dorobic reszte
				default: return null;
			}
		}
	}
	
	private Variable add(Variable v1, Variable v2){
		VariableType t = learnTypes(v1,v2);
		switch(t){
			case INT: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readInt(v1.getValue())+reader.readInt(v2.getValue())))));
			case CHAR: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readChar(v1.getValue())+reader.readChar(v2.getValue())))));
			case DOUBLE: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readDouble(v1.getValue())+reader.readDouble(v2.getValue())))));
			default: return null;
		}
	}
	
	private Variable mull(Variable v1, Variable v2){
		VariableType t = learnTypes(v1,v2);
		switch(t){
			case INT: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readInt(v1.getValue())*reader.readInt(v2.getValue())))));
			case CHAR: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readChar(v1.getValue())*reader.readChar(v2.getValue())))));
			case DOUBLE: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readDouble(v1.getValue())*reader.readDouble(v2.getValue())))));
			default: return null;
		}
	}
	
	private Variable sub(Variable v1, Variable v2){
		VariableType t = learnTypes(v1,v2);
		switch(t){
			case INT: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readInt(v1.getValue())-reader.readInt(v2.getValue())))));
			case CHAR: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readChar(v1.getValue())-reader.readChar(v2.getValue())))));
			case DOUBLE: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readDouble(v1.getValue())-reader.readDouble(v2.getValue())))));
			default: return null;
		}
	}
	
	private Variable div(Variable v1, Variable v2){
		VariableType t = learnTypes(v1,v2);
		switch(t){
			case INT: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readInt(v1.getValue())/reader.readInt(v2.getValue())))));
			case CHAR: return (builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readChar(v1.getValue())/reader.readChar(v2.getValue())))));
			default: return null;
		}
	}
	
	private void push(Variable v){
		memory.onStack(v); //push
	}
	
	private Variable pop(){
		return memory.offStack();
	}
	
	private Variable ret(){
		return pop();
	}
	
	public void execute(String name){//przykładowe dzialanie, cala metode mozna wyczyscic
		//Method m = klasa.getMethod(name);
		Variable v1 = builder.buildAtributeOut("A", VariableType.INT, (Object) 3);
		Variable v2 = builder.buildAtributeOut("B", VariableType.INT, (Object) 4);
		push(v1);
		push(v2);
		System.out.println("WYNIK: "+ (mull(pop(),pop())).getValue());
	}
	
}

