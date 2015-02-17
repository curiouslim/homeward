package conf;

import java.util.List;

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
import com.homeward.orm.ZipCode;

import play.Logger;

public class Global extends GlobalSettings {

	private Injector injector;

	@Override
	public void onStart(Application appliation) {
		injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
			}
		});

		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder();
		ServiceRegistry registry = serviceRegistry.applySettings(
				configuration.getProperties()).build();

		SessionFactory sessionFactory = configuration
				.buildSessionFactory(registry);

		Session session = sessionFactory.openSession();
		List<ZipCode> zipCodes = session.createCriteria(ZipCode.class).list();

		System.out.println("here");
		System.out.println("zip codes: " + zipCodes.size());
		Logger.info("ZIP CODES {}", zipCodes.size());
		session.close();
	}
}