package controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.homeward.orm.State;
import com.homeward.orm.ZipCode;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	public static Result index() {

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

		return ok(index.render("Hello World."));
	}

}
