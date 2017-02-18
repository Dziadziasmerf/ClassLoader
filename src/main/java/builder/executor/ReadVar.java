package builder.executor;

public class ReadVar {
	public ReadVar(){};

	public int readInt(Object o){
		return Integer.parseInt(o.toString());
	}

	public double readDouble(Object o){
		return Double.parseDouble(o.toString());
	}

	public char readChar(Object o){
		return (o.toString()).charAt(0);
	}

	public String readString(Object o){
		return o.toString();
	}

	public float readFloat(Object o){
		return Float.parseFloat(o.toString());
	}

	public byte[] readByte(Object o){
		return o.toString().getBytes();
	}

	public long readLong(Object o){
		return Long.parseLong(o.toString());
	}
}
