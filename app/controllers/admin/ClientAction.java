package controllers.admin;

import helper.ActionHelper;

import java.util.List;

import models.Client;
import models.BaseModel;
import util.SqlUtil;
import util.StringUtil;

import business.ClientProcess;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import controllers.BaseController;
import dwz.DwzMessager;

public class ClientAction extends BaseController {
	public static void add() {
		render("admin/client/clientInfo.html");
	}

	public static void info(Long id) {
		Client client = (Client) (id == null ? null : Client.findById(id));
		render("admin/client/clientInfo.html", client);
	}

	public static void copy(Long id) {
		Client clientOld = (Client) (id == null ? null : Client.findById(id));
		Client client = (Client) clientOld.copy(new Client());
		client.id = null;
		render("admin/client/clientInfo.html", client);
	}

	public static void list(Client client) {
		List<Client> clients = ClientProcess.getInstance()
				.getClientList(client);
		render("admin/client/clientList.html", clients, client);
	}

	public static void select(Client client) {
		List<Client> clients = ClientProcess.getInstance()
				.getClientList(client);
		render("admin/client/clientSelect.html", clients, client);
	}

	public static void save(Client client) {
		validation.required(client.clientName);
		if (client.isAdd()) {
			if (client.isDuplicate()) {
				validation.addError(client.clientName,
						"error.massge.name.duplicate.user", client.clientName);
			}
		}
		if (validation.hasErrors()) {
			renderJSON(DwzMessager.getErrorMessager(validation.errors()));
		}
		client.save();
		renderJSON(DwzMessager.getSuccessAndColseMessager());
	}

	public static void delete(Long id) {
		Client user = Client.findById(id);
		user.delete();
		renderJSON(DwzMessager.success);
	}

	public static void lookup(Client client) {
		List<Client> clients = null;
		if (StringUtil.isEmpty(client.clientName)) {
			clients = Client.findAll();
		} else {
			clients = Client.find("clientName like ?",
					SqlUtil.buildFullLike(client.clientName)).fetch(20);
		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		renderJSON(gson.toJson(clients));
	}
}
