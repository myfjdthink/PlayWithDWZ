package models;

import interfaces.NameAble;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "capacitys")
public class Capacity extends Model {

	@Required
	@MaxSize(15)
	@MinSize(6)
	@Match(value = "^\\w*$", message = "Not a valid username")
	public String username;

	@Required
	@MaxSize(15)
	@MinSize(6)
	public String password;

	@Required
	@MaxSize(100)
	public String name;

	public Capacity(String name, String password, String username) {
		this.name = name;
		this.password = password;
		this.username = username;
	}

	public String toString() {
		return "User(" + username + ")";
	}

	public boolean isAdd() {
		return id == null;
	}

}
