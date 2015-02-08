package util;

public class NumberUtil {
	public static Double toDouble(Object obj, Double defaultValue){
		if(obj == null){
			return defaultValue;
		}
		return (Double) obj;
	}
}
