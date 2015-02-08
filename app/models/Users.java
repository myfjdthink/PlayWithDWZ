package models;

import interfaces.NameAble;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name = "users")
public class Users extends BaseModel implements NameAble {
	public static String USERTYPE_CLIENT = "client";
	public static String USERTYPE_INTER = "inter";
	
	@Required
	@MaxSize(15)
	@MinSize(6)
	@Match(value = "^\\w*$", message = "Not a valid username")
	public String username;

	@Required
	@MaxSize(15)
	@MinSize(6)
	public String password;
	
	@Expose 
	@SerializedName("clientName")  
	@Required
	@MaxSize(100)
	public String name;
	@Expose 
	public String phone;
	@Expose 
	public String contacts;
	@Expose 
	public String directLine;
	public String email;
	public String remark;
	@Expose 
	public String address;

	@Required
	@MaxSize(20)
	private String userType;

	public Users() {
		super();
	}

	public Users(String name, String password, String username) {
		this.name = name;
		this.password = password;
		this.username = username;
	}

	public String toString() {
		return "User(" + username + ")";
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String getNameStr() {
		return "name";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

}
