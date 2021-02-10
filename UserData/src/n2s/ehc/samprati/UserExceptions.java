package n2s.ehc.samprati;


public class UserExceptions {
	public boolean validateOption(int ch) throws InvalidEntry{
		if(ch< 1 || ch > 5) {
			throw new InvalidEntry("Invalid Option Selected");
		}
		return false;
	}
	
	public boolean validateId(boolean b) throws InvalidUserId{
		if(b) {
			throw new InvalidUserId("User Id already exist.Try different");
		}
		return false;		
	}
	
	public boolean idUnavailable(boolean b) throws UserIdNotFound{
		if(b) {
			throw new UserIdNotFound("User Id not available.Try different");
		}
		return false;		
	}
	

}

class InvalidEntry extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6526286840532554429L;

	public InvalidEntry(String s) {
		super(s);
	}

}

class InvalidUserId extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1559429130011679525L;

	public InvalidUserId(String s) {
		super(s);
	}

}

class UserIdNotFound extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7731190159292513233L;

	public UserIdNotFound(String s) {
		super(s);
	}
}
