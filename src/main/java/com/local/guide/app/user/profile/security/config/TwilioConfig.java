package com.local.guide.app.user.profile.security.config;

import java.util.Objects;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/*@Configuration
@ConfigurationProperties(prefix = "twilio")
@Data
public class TwilioConfig {
	private String accountSid;
	private String authToken;
	private String trialNumber;

	public String getAccountSid() {
		return accountSid;
	}

	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}

	public String getAuthToken() {
		return authToken;
	}

	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}

	public String getTrialNumber() {
		return trialNumber;
	}

	public void setTrialNumber(String trialNumber) {
		this.trialNumber = trialNumber;
	}

	public TwilioConfig(String accountSid, String authToken, String trialNumber) {
		super();
		this.accountSid = accountSid;
		this.authToken = authToken;
		this.trialNumber = trialNumber;
	}

	public TwilioConfig() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountSid, authToken, trialNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TwilioConfig other = (TwilioConfig) obj;
		return Objects.equals(accountSid, other.accountSid) && Objects.equals(authToken, other.authToken)
				&& Objects.equals(trialNumber, other.trialNumber);
	}

}*/
