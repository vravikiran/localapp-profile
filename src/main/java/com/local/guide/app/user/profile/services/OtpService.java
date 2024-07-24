package com.local.guide.app.user.profile.services;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.local.guide.app.user.profile.entities.AuthRequest;

@Service
public class OtpService {
//	@Autowired
//	TwilioConfig twilioConfig;
	private LoadingCache<String, String> otpCache;
	private static final Integer EXIPIRE_MIN = 5;

	public OtpService() {
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXIPIRE_MIN, TimeUnit.MINUTES).build(new CacheLoader<>() {
			@Override
			public String load(String s) {
				return "";
			}
		});

	}

	public String generateOtp(String mobileNo) {
		//PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
		//PhoneNumber to = new PhoneNumber("+91" + mobileNo);
		String otpMessage = "Please find the OTP to validate your identity: " + getRandomOtp(mobileNo);
		//Message.creator(to, from, otpMessage).create();
		return otpMessage;
	}

	private String getRandomOtp(String mobileNo) {
		String otp = String.valueOf(new Random().nextInt(1000,10000));
		otpCache.put(mobileNo, otp);
		return otp;
	}

	public boolean validateOtp(AuthRequest authRequest) throws ExecutionException {
		if (otpCache.get(authRequest.getMobileNo()) != null
				&& otpCache.get(authRequest.getMobileNo()).equals(authRequest.getOtp())) {
			clearOtpCache(authRequest.getMobileNo());
			return true;
		}
		return false;
	}

	private void clearOtpCache(String mobileNo) {
		otpCache.invalidate(mobileNo);
	}
}
