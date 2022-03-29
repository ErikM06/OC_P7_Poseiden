package customExceptions;

public class CustomBidNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomBidNotFoundException (String msg) {
		super(msg);	
	}

}
