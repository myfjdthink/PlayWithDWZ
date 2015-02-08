package interfaces;

public interface NameAble {
	/**
	 * 返回name属性的字符串, 用于拼sql.
	 * @return Name Description
	 */
	public String getNameStr();
	
	public String getName();

	public void setName(String name);
}
