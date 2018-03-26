package com.hp.logs.treatment.message;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentLogMessage extends TreatmentHandler {

	public static final Logger logger = Logger.getLogger(TreatmentLogMessage.class.getCanonicalName());
	
	public TreatmentLogMessage(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.info(String.format("TreatmentLogMessage"));
		
		LogInfo datum = null;
		
		if (node.has("message_content") && node.has("message_status")) {
			datum = nextValidation.process(node);
		} else {
			statsMng.countMissingFields();
		}
		
		return datum;	
	}
}
