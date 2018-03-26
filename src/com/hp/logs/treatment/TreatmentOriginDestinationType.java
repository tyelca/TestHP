package com.hp.logs.treatment;

import java.io.IOException;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.CountryCode;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.entity.MSISDN;
import com.hp.logs.entity.MessageType;

public class TreatmentOriginDestinationType extends TreatmentHandler {

	public static final Logger logger = Logger.getLogger(TreatmentOriginDestinationType.class.getCanonicalName());
	
	public TreatmentOriginDestinationType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.info(String.format("TreatmentOriginDestinationType"));
		
		LogInfo datum = null;
		
		try {
			
			MSISDN.getValue(node.get("destination"));
			
			CountryCode countryCodeOrigin = CountryCode.fromMSISDN(MSISDN.getValue(node.get("origin")));		
			CountryCode countryCodeDestination = CountryCode.fromMSISDN(MSISDN.getValue(node.get("destination")));
			
			statsMng.countOriginCountryCode(countryCodeOrigin);
			statsMng.countDestinationCountryCode(countryCodeDestination);
			
			MessageType.fromValue(node.get("message_type"));
			
					
			datum = nextValidation.process(node);
		} catch (IOException e) {
			statsMng.countFieldError();
		}
		
		return datum;
	}

}
