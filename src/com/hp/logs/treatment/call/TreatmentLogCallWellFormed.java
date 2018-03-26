package com.hp.logs.treatment.call;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogCall;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentLogCallWellFormed extends TreatmentHandler {
	
	public static final Logger logger = Logger.getLogger(TreatmentLogCallWellFormed.class.getCanonicalName());
	
	public TreatmentLogCallWellFormed(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.info(String.format("TreatmentLogCallWellFormed"));
		
		long origin = node.get("origin").asLong();
		long destination = node.get("destination").asLong();
		int duration = node.get("duration").asInt();
		
		statsMng.countCallsByCountry (origin, duration);
		
		statsMng.countCallsCount();
			
		return new LogCall(node.get("message_type").asText(), node.get("timestamp").asInt(),
				origin, destination, duration,
				node.get("status_code").asText(), node.get("status_description").asText());

	}

}
