package free.asinbow.model;

import com.jfinal.plugin.activerecord.Model;

public class User extends Model<User> {
	public static final User dao = new User();
	public static final long serialVersionUID = 1;
}
