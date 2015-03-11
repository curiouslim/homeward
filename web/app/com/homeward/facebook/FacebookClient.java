package com.homeward.facebook;

import play.Logger;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.restfb.DefaultFacebookClient;
import com.restfb.Version;

public class FacebookClient extends DefaultFacebookClient {

	@Inject
	@Named("facebook.app.id")
	String facebookAppId;

	@Inject
	@Named("facebook.secret.token")
	String facebookSecretToken;

	@Inject
	public FacebookClient() {
		// super(Version.VERSION_2_0);

		Logger.info("app id: " + facebookAppId);
		Logger.info("secret: " + facebookSecretToken);
		this.facebookAppId = facebookAppId;
		this.facebookSecretToken = facebookSecretToken;
		AccessToken accessToken = this.obtainAppAccessToken(facebookAppId,
				facebookSecretToken);
		this.accessToken = accessToken.getAccessToken();
	}

	public String getFacebookAppId() {
		return facebookAppId;
	}

	public void setFacebookAppId(String facebookAppId) {
		this.facebookAppId = facebookAppId;
	}

	public String getFacebookSecretToken() {
		return facebookSecretToken;
	}

	public void setFacebookSecretToken(String facebookSecretToken) {
		this.facebookSecretToken = facebookSecretToken;
	}
}
