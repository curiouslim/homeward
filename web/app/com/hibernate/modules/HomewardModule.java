package com.hibernate.modules;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import play.Logger;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.homeward.facebook.FacebookClient;
import com.restfb.DefaultFacebookClient;

public class HomewardModule extends AbstractModule {

	@Override
	protected void configure() {
		try {
			Properties properties = new Properties();
			properties.load(new FileReader("conf/app.properties"));
			Names.bindProperties(binder(), properties);

			bind(DefaultFacebookClient.class).to(FacebookClient.class);

		} catch (IOException ex) {
			Logger.error("Can't find properties file.");
		}
	}
}