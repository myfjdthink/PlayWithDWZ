package util;

public class SqlUtil {
	public static String buildFullLike(String value) {
		return "%" + value + "%";
	}

	public static String buildLeftLike(String value) {
		return "%" + value;
	}

	public static String buildRightLike(String value) {
		return value + "%";
	}
}