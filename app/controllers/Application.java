package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    public static void loginPage() {
    	render();
    }
    public static void list() {
    	render();
    }
	public static void doLogin() {
		
	}
	public static void login(String username, String password) {
        Users user = Users.find("byUsernameAndPassword", username, password).first();
        if(user != null) {
            session.put("user", user.username);
            flash.success("Welcome, " + user.name);
            Application.index();         
        }
        // 回到登陆页面
        flash.put("username", username);
        flash.error("Login failed");
        loginPage();
    }
	public static void logout() {
        session.clear();
        loginPage();
    }
}