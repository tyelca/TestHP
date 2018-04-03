package com.hp.logs.treatment;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;

public class TreatmentLogInfoType extends TreatmentHandler {

	public static final Logger logger = LogManager.getLogger(TreatmentLogInfoType.class.getCanonicalName());	
	
	public TreatmentLogInfoType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.debug(String.format("TreatmentLogInfoType - Node = %s", node.toString()));
		
		LogInfo datum = null;
		
		if (node.get("message_type").isTextual() && node.get("timestamp").isInt() && node.get("origin").isLong()
				&& node.get("destination").isLong()) {
			datum = nextValidation.process(node);
		} else {
			statsMng.countFieldError();
		}
		
		return datum;
	}

}
