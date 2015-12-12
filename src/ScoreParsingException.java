
public class ScoreParsingException extends Exception {

	private int errorType;

	public ScoreParsingException(int errorType) {
		/* fill code */
		this.errorType = errorType;
	}

	public String getMessage() {
		/* fill code */
		String msg = "";
		if (errorType == 0) {
			msg = "No record score";
		} else {
			msg = "Wrong record format";
		}
		return msg;
	}
}

