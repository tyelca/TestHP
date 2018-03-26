package com.hp.logs.treatment;

import java.io.IOException;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.entity.MessageType;

public class TreatmentMessageType extends TreatmentHandler {

	public static final Logger logger = Logger.getLogger(TreatmentMessageType.class.getCanonicalName());
	
	public TreatmentMessageType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.info(String.format("TreatmentMessageType"));
				
		LogInfo datum = null;
		
		try {
			MessageType.fromValue(node.get("message_type"));
		
			datum = nextValidation.process(node);
		} catch (IOException e) {
			statsMng.countFieldError();
		}
		
		return datum;
	}

}
