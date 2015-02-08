package interfaces;

import play.db.jpa.Model;

public interface MatchAble {
	public Model matchObj(String name);

	public Model matchObjs(String names);
}
