package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.google.inject.Inject;
import com.homeward.facebook.FacebookClient;
import com.homeward.orm.State;
import com.homeward.orm.ZipCode;
import com.restfb.DefaultFacebookClient;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	@Inject
	private DefaultFacebookClient fbClient;

	public Result index() {

		Configuration configuration = new Configuration();
		configuration.configure();
		StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder();
		ServiceRegistry registry = serviceRegistry.applySettings(
				configuration.getProperties()).build();

		SessionFactory sessionFactory = configuration
				.buildSessionFactory(registry);

		Session session = sessionFactory.openSession();
		List<ZipCode> zipCodes = session.createCriteria(ZipCode.class).list();
		Logger.info("ZIP CODES {}", zipCodes.size());
		session.close();
		
		System.out.println("FB: " + ((FacebookClient) fbClient).getFacebookAppId());

		return ok(index.render("Hello World."));
	}
}
