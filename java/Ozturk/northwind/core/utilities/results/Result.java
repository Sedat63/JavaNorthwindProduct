package Ozturk.northwind.core.utilities.results;

public class Result { // burada soyut görevi görür

	private boolean success;
	private String message;
	
	
	public Result(boolean success) {
		
		this.success = success;
	}
	
	public Result(boolean success, String message) {
		
		this(success);
		this.message = message;
	}
	
	public boolean isSuccess() {
		return this.success;
	}
	
	public String getMessage(){
		return this.message;
	}
	
	
}
