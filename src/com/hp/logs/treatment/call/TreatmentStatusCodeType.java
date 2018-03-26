package com.hp.logs.treatment.call;

import java.io.IOException;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.entity.StatusCodeType;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentStatusCodeType extends TreatmentHandler {
	
	public static final Logger logger = Logger.getLogger(TreatmentStatusCodeType.class.getCanonicalName());
	
	public TreatmentStatusCodeType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.info(String.format("TreatmentStatusCodeType"));
		
		LogInfo datum = null;
		
		try {
			StatusCodeType statusCode = StatusCodeType.fromValue(node.get("status_code"));

			statsMng.countCallsByStatusCode(statusCode);

			datum = nextValidation.process(node);

		} catch (IOException e) {
			statsMng.countFieldError();
		}
		
		return datum;
	}

}
