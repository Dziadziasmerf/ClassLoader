package builder.executor;

import builder.memory.*;
import builder.elements.*;
import factory.methods.*;
import factory.variables.*;
import factory.*;
import builder.building.*;
import java.util.*;

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
	
	public VariableType learnTypes(Variable v1, Variable v2){
		if(v1.getType() != v2.getType()){
			return null;
		}else{
			VariableType t = v1.getType();
			switch(t){
				case INT: return VariableType.INT;
				case CHAR: return VariableType.CHAR;
				case DOUBLE: return VariableType.DOUBLE;
				case LONG: return VariableType.LONG;
				case STRING: return VariableType.STRING;
				case BYTE: return VariableType.BYTE;
				case FLOAT: return VariableType.FLOAT;
				default: return null;
			}
		}
	}
	
	public void add(){
		System.out.println("POCZ ADD");
		memory.print();
		Variable v1 = pop();
		System.out.println("POP1"+ v1.getType());
		Variable v2 = pop();
		System.out.println("POP2"+v2.getType());
		VariableType t = learnTypes(v1,v2);
		System.out.println(t);
		System.out.println("AAAAA" + builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readInt(v1.getValue())+reader.readInt(v2.getValue())))).getValue());
		switch(t){
			case INT: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readInt(v1.getValue())+reader.readInt(v2.getValue()))))); break;
			case CHAR: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readChar(v1.getValue())+reader.readChar(v2.getValue()))))); break;
			case DOUBLE: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readDouble(v1.getValue())+reader.readDouble(v2.getValue()))))); break;
			case FLOAT: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readFloat(v1.getValue())+reader.readFloat(v2.getValue()))))); break;
			case STRING: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readString(v1.getValue())+reader.readString(v2.getValue()))))); break;
			case LONG: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readLong(v1.getValue())+reader.readLong(v2.getValue()))))); break;
			default: push(null);
		}
	}
	
	public void mull(){
		Variable v1 = pop();
		Variable v2 = pop();
		VariableType t = learnTypes(v1,v2);
		switch(t){
		case INT: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readInt(v1.getValue())*reader.readInt(v2.getValue()))))); break;
		case CHAR: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readChar(v1.getValue())*reader.readChar(v2.getValue()))))); break;
		case DOUBLE: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readDouble(v1.getValue())*reader.readDouble(v2.getValue()))))); break;
		case FLOAT: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readFloat(v1.getValue())*reader.readFloat(v2.getValue()))))); break;
		case LONG: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readLong(v1.getValue())*reader.readLong(v2.getValue()))))); break;
		default: push(null);
		}
	}
	
	public void sub(){
		Variable v1 = pop();
		Variable v2 = pop();
		VariableType t = learnTypes(v1,v2);
		switch(t){
		case INT: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readInt(v1.getValue())-reader.readInt(v2.getValue()))))); break;
		case CHAR: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readChar(v1.getValue())-reader.readChar(v2.getValue()))))); break;
		case DOUBLE: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readDouble(v1.getValue())-reader.readDouble(v2.getValue()))))); break;
		case FLOAT: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readFloat(v1.getValue())-reader.readFloat(v2.getValue()))))); break;
		case LONG: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readLong(v1.getValue())-reader.readLong(v2.getValue()))))); break;
		default: push(null);
		}
	}
	
	public void div(){
		Variable v1 = pop();
		Variable v2 = pop();
		VariableType t = learnTypes(v1,v2);
		switch(t){
		case INT: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readInt(v1.getValue())/reader.readInt(v2.getValue()))))); break;
		case CHAR: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readChar(v1.getValue())/reader.readChar(v2.getValue()))))); break;
		case DOUBLE: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readDouble(v1.getValue())/reader.readDouble(v2.getValue()))))); break;
		case FLOAT: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readFloat(v1.getValue())/reader.readFloat(v2.getValue()))))); break;
		case LONG: push(builder.buildAtributeOut(v1.name, v1.getType(),((Object)(reader.readLong(v1.getValue())/reader.readLong(v2.getValue()))))); break;
		default: push(null);
		}
	}
	
	public void push(Variable v){
		memory.onStack(v);
	}
	
	public Variable pop(){
		if(memory.isStosEmpty() == false) return memory.offStack();
		return null;
	}
	
	public Variable ret(){
		if (memory.isStosEmpty() == false){
			Variable v = pop();
			System.out.println("Zwracana wartosc z metody: " + v.getValue().toString());
			return v;
		}
		return null;
	}
	
}
