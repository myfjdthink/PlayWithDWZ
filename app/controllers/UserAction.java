package controllers;

import helper.ActionHelper;

import java.util.List;

import models.Users;
import dwz.DwzMessager;

public class UserAction extends BaseController {

	public static void info(Long id) {
		Users user = (Users) (id == null ? null : Users.findById(id));
		render("user/userInfo.html", user);
	}

	public static void list() {
		List<Users> users = Users.findAll();
		render("user/userList.html", users);
	}

	public static void save(Users user) {
		if (user.isAdd()) {
//			if (ActionHelper.hasName(user, user.username)) {
//				validation.addError(user.username, "已经存在名为{0}的用户",
//						user.username);
//			}
		}
		validation.required(user.username);
		validation.required(user.password);
		validation.required(user.name);
		validation.minSize(user.password, 6);
		if (validation.hasErrors()) {
			renderJSON(DwzMessager.getErrorMessager(validation.errors()));
		}
		user.save();
		renderJSON(DwzMessager.getSuccessAndColseMessager());
	}

	public static void delete(Long id) {
		Users user = Users.findById(id);
		user.delete();
		renderJSON(DwzMessager.success);
	}

	public static void hasName(Users user) {
//		if (ActionHelper.hasName(user, user.username)) {
//			renderJSON("false");
//		} else {
//			renderJSON("true");
//		}
	}
}
