package com.local.guide.app.user.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProfileApplication {
	/*@Autowired
	private TwilioConfig twilioConfig;*/

	public static void main(String[] args) {
		SpringApplication.run(ProfileApplication.class, args);
	}
	/*@PostConstruct
	public void initTwilio(){
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}*/

}
