package com.hp.logs.treatment;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.entity.MessageType;

public class TreatmentMessageType extends TreatmentHandler {

	public static final Logger logger = LogManager.getLogger(TreatmentMessageType.class.getCanonicalName());
	
	public TreatmentMessageType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.debug(String.format("TreatmentMessageType - Node = %s", node.toString()));;
				
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
