package com.hp.logs.treatment.call;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogCall;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentLogCallWellFormed extends TreatmentHandler {

	public static final Logger logger = LogManager.getLogger(TreatmentLogCallWellFormed.class.getCanonicalName());

		
	public TreatmentLogCallWellFormed(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.debug(String.format("TreatmentLogCallWellFormed - Node = %s", node.toString()));
		
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
