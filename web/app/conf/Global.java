package conf;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import play.Application;
import play.GlobalSettings;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Guice;
import com.hibernate.modules.HomewardModule;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;

public class Global extends GlobalSettings {

	private static final Injector injector = createInjector();

	@Override
	public void onStart(Application appliation) {
		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder();
		ServiceRegistry registry = serviceRegistry.applySettings(
				configuration.getProperties()).build();

		SessionFactory sessionFactory = configuration
				.buildSessionFactory(registry);

		Session session = sessionFactory.openSession();
		session.close();
	}

	@Override
	public <T> T getControllerInstance(Class<T> aClass) throws Exception {
		System.out.println("in controller instance");
		return injector.getInstance(aClass);
	}
	
	private static Injector createInjector() {
		return Guice.createInjector(new HomewardModule());
	}
}