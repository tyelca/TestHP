package com.hp.logs.treatment.message;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentLogMessageType extends TreatmentHandler {
	
	public static final Logger logger = LogManager.getLogger(TreatmentLogMessageType.class.getCanonicalName());

	public TreatmentLogMessageType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.debug(String.format("TreatmentLogMessageType - Node = %s", node.toString()));
		
		LogInfo datum = null;

		if (node.get("message_content").isTextual() && node.get("message_status").isTextual()) {
			datum = nextValidation.process(node);
		} else {
			statsMng.countFieldError();
		}
		
		return datum;
	}

}
