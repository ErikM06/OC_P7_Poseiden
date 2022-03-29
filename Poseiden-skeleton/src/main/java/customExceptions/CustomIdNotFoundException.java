package customExceptions;

public class CustomIdNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomIdNotFoundException (String msg) {
		super(msg);	
	}

}
