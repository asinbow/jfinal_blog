package demo;

import com.jfinal.core.Controller;

import demo.model.User;

public class HelloController extends Controller {
	
	public void index() {
		User user = null;
		try {
			int id = Integer.parseInt(getPara("id"));
			user = User.dao.findById(id);
		} catch (NumberFormatException e) {
			String passport_id = getPara("passport_id");
			user = User.dao.findFirst("select * from User where passport_id = ?", passport_id);
		}
		if (user!=null) {
			renderJson(user);
		} else {
			renderError404();
		}
	}
	
	public void report() {
		renderText("Hello, Jfinal.\n" + getCookie("rock_format"));
	}
	
	public void view() {
		render("view.html");
		//render("view.html");
	}

}
