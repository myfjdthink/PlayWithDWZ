package models;

import java.util.HashMap;
import java.util.Map;

import interfaces.DuplicateAble;
import interfaces.MatchAble;
import interfaces.NameAble;

import javax.persistence.Entity;
import javax.persistence.Table;

import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import util.StringUtil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity
public class Client extends Company implements NameAble, DuplicateAble,
		MatchAble {

	@Override
	public String getNameStr() {
		return "clientName";
	}

	@Override
	public String getName() {
		return clientName;
	}

	@Override
	public void setName(String name) {
		clientName = name;
	}

	public boolean isDuplicate() {
		return isDuplicate(clientName, id);
	}

	@Override
	public boolean isDuplicate(String name, Long excludeId) {
		if (StringUtil.isEmpty(name)) {
			return false;
		}
		if (excludeId != null) {
			return this.find(getNameStr() + "=? and id <> ? ", name, excludeId)
					.fetch().size() > 0;
		} else {
			return this.find(getNameStr() + "=?", name).fetch().size() > 0;
		}

	}

	@Override
	public Model matchObj(String name) {
		return (Client) this.find(getNameStr() + " = ?", name).first();
	}

	@Override
	public Model matchObjs(String names) {
		// names.split(",");
		// this.find(getNameStr() + "= ? ", name).first();
		// // TODO Auto-generated method stub
		return null;
	}

}
