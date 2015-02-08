package business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import models.Client;
import play.db.jpa.JPA;
import util.SqlUtil;
import util.StringUtil;

public class ClientProcess extends BaseProcess {
	private static ClientProcess process;

	public static ClientProcess getInstance() {
		if (process == null) {
			process = new ClientProcess();
		}
		return process;
	}

	public List<Client> getClientList(Client client) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuilder hql = new StringBuilder("from Client c where 1=1 ");
		if (!StringUtil.isEmpty(client.clientName)) {
			hql.append(" and c.clientName like :clientName ");
			params.put("clientName", SqlUtil.buildFullLike(client.clientName));
		}
		if (!StringUtil.isEmpty(client.phone)) {
			hql.append(" and c.phone like :phone ");
			hql.append(" or c.directLine like :phone ");
			params.put("phone", SqlUtil.buildFullLike(client.phone));
			params.put("phone", SqlUtil.buildFullLike(client.phone));
		}

		Query query = JPA.em().createQuery(hql.toString());
		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
		List<Client> clients = query.getResultList();
		return clients;
	}

}
