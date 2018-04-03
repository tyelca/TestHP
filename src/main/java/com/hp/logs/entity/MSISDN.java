package com.hp.logs.entity;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.JsonNode;

public class MSISDN {

	private static final String MSISDN_FORMAT = "\\d{1,15}";

	private MSISDN() {
		throw new IllegalStateException("MSISDN class");
	}

	public static Long getValue(JsonNode node) throws IOException {
		long mobileId = node.asLong();

		Pattern p = Pattern.compile(MSISDN_FORMAT);
		Matcher matcher = p.matcher(String.valueOf(mobileId));

		if (matcher.matches() && (CountryCode.fromMSISDN(mobileId) != null)) {
			return mobileId;
		} else {
			throw new IOException(String.format("MSISDN - Incorrect value : %s", mobileId));
		}
	}


}
