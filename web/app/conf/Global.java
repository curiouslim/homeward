package conf;

import play.Application;
import play.GlobalSettings;
import com.google.inject.AbstractModule;
import com.google.inject.Injector;
import com.google.inject.Guice;

public class Global extends GlobalSettings {

	private Injector injector;

	@Override
	public void onStart(Application appliation) {
		injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
			}
		});
	}
}