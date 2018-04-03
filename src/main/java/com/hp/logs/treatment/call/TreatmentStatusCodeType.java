package com.hp.logs.treatment.call;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.entity.StatusCodeType;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentStatusCodeType extends TreatmentHandler {
	
	public static final Logger logger = LogManager.getLogger(TreatmentStatusCodeType.class.getCanonicalName());
	
	public TreatmentStatusCodeType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.debug(String.format("TreatmentStatusCodeType - Node = %s", node.toString()));
		
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
