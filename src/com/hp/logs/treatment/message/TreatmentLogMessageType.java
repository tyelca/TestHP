package com.hp.logs.treatment.message;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentLogMessageType extends TreatmentHandler {
	
	public static final Logger logger = Logger.getLogger(TreatmentLogMessageType.class.getCanonicalName());

	public TreatmentLogMessageType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.info(String.format("TreatmentLogMessageType"));
		
		LogInfo datum = null;

		if (node.get("message_content").isTextual() && node.get("message_status").isTextual()) {
			datum = nextValidation.process(node);
		} else {
			statsMng.countFieldError();
		}
		
		return datum;
	}

}
