package Model;

public class Packet<T> {

	
	private T data;
	
	private Class<?> objectType;
	
	public Packet(T data){
		this.data = data;
		objectType = data.getClass();
	}
	
	public T getData(){
		return data;
	}
	
	public Class<? extends Object> getDataClass(){
		return objectType;
	}
	
}
