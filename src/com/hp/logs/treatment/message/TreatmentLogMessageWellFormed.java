package com.hp.logs.treatment.message;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.entity.LogMessage;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentLogMessageWellFormed extends TreatmentHandler {
	
	public static final Logger logger = Logger.getLogger(TreatmentLogMessageWellFormed.class.getCanonicalName());

	public TreatmentLogMessageWellFormed(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {
		
		logger.info(String.format("TreatmentLogMessageWellFormed"));
		
		statsMng.countMessagesCount();
		
		return new LogMessage(node.get("message_type").asText(), node.get("timestamp").asInt(),
				node.get("origin").asLong(), node.get("destination").asLong(),
				node.get("message_content").asText(),node.get("message_status").asText());
	}

}
