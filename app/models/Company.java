package models;

import play.*;
import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.*;

@Entity
public class Company extends BaseModel {
	@Expose
	//@SerializedName("clientName")
	@Required
	@MaxSize(100)
	public String clientName;
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

}
