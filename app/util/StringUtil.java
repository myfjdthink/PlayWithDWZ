package util;

public class StringUtil {
	public static boolean isEmpty(String obj) {
		if (obj == null || obj.equals("") || obj.trim().equals("")) {
			return true;
		}
		return false;
	}

	public static Integer toInteger(String obj, int defaultValue) {
		if (obj == null) {
			return defaultValue;
		}
		Integer result = null;
		try {
			result = Integer.valueOf(obj);
		} catch (Exception e) {
			return defaultValue;
		}
		return result;
	}
}
