
public class ScoreParsingException extends Exception {

	private int errorType;

	public ScoreParsingException(int errorType) {
		this.errorType = errorType;
	}

	public String getMessage() {
		String msg = "";
		if (errorType == 0) {
			msg = "No record score";
		} else {
			msg = "Wrong record format";
		}
		return msg;
	}
}
