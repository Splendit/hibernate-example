package at.splendit.example.hibernate.app;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;

public class AppSingleton implements ApplicationContextAware {

	@Autowired
	private static ApplicationContext applicationContext;
	private static AppSingleton INSTANCE = new AppSingleton();

	private AppSingleton() {
	}

	public static AppSingleton getInstance() {
		return INSTANCE;
	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (AppSingleton.applicationContext != null && AppSingleton.applicationContext != applicationContext) {
			throw new IllegalStateException("Spring Context already set!");
		} else {
			AppSingleton.applicationContext = (ConfigurableApplicationContext) applicationContext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
}
