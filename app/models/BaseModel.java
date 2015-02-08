package models;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import interfaces.NameAble;
import play.db.jpa.JPABase;
import play.db.jpa.JPQL;
import play.db.jpa.Model;

public class BaseModel extends Model {
	public boolean isAdd() {
		return id == null;
	}

	public Model copy(Model model) {
		try {
			BeanUtils.copyProperties(model, this);
		} catch (IllegalAccessException | InvocationTargetException e) {
			return model;
		}
		return model;
	}

}
