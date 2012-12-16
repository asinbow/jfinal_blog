package demo;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

import demo.model.User;

public class DemoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		//me.setViewType(ViewType.FREE_MARKER);
		//me.setBaseViewPath("/WEB-INF/path");
	}

	@Override
	public void configHandler(Handlers me) {
	}

	@Override
	public void configInterceptor(Interceptors me) {
	}

	@Override
	public void configPlugin(Plugins me) {
		//C3p0Plugin c3p0plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("pass"));
		C3p0Plugin c3p0plugin = new C3p0Plugin("jdbc:mysql://localhost/saybot_vw", "saybot", "saybot");
		
		ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(c3p0plugin);
		activeRecordPlugin.addMapping("User", User.class);
		
		me.add(c3p0plugin);
		me.add(activeRecordPlugin);
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/hello", HelloController.class);
	}
	
	public static void main(String[] args) {
		JFinal.start("WebRoot", 9999, "/", 5);
	}	

}
