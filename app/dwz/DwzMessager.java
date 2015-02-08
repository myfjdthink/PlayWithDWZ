package dwz;

import java.util.List;

import play.data.validation.Error;
import play.i18n.Messages;

public class DwzMessager {
	public static String successCode = "200";
	public static String errorCode = "300";
	public static String timeCodeCode = "301";

	public static DwzMessager error = new DwzMessager();
	public static DwzMessager success = new DwzMessager();

	static {
		error.statusCode = errorCode;
	}

	public DwzMessager() {
		super();
	}

	public String statusCode = successCode;
	public String message = "";
	public String navTabId = "";
	public String rel = "";
	public String callbackType = "";
	public String forwardUrl = "";
	public String confirmMsg = "";

	public static DwzMessager getTimeMessager() {
		DwzMessager dwzMessage = getMessager(timeCodeCode, "操作超时");
		return dwzMessage;
	}

	public static DwzMessager getSuccessAndColseMessager() {
		DwzMessager dwzMessage = getMessager(successCode, "操作成功");
		dwzMessage.callbackType = "closeCurrent";
		return dwzMessage;
	}

	public static DwzMessager getSuccessMessager() {
		DwzMessager dwzMessage = getMessager(successCode, "操作成功");
		return dwzMessage;
	}

	public static DwzMessager getErrorMessager(List<Error> errors) {
		String message = "";
		for (Error e : errors) {
			message += e.message() + "\n";
		}
		DwzMessager dwzMessage = getMessager(errorCode, message);
		return dwzMessage;
	}

	public static DwzMessager getMessager(String statusCode, String message) {
		DwzMessager dwzMessage = new DwzMessager();
		dwzMessage.statusCode = statusCode;
		dwzMessage.message = message;
		return dwzMessage;
	}
}
