package helper;

import interfaces.NameAble;
import play.db.jpa.Model;

public class ActionHelper extends BaseHelper {
	public static boolean hasName(Model model, NameAble obj, String name) {
		return model.find(obj.getNameStr() + "=?", obj.getName()).fetch()
				.size() > 0;
	}
}
