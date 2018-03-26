package com.hp.logs.treatment.call;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentLogCallType extends TreatmentHandler {
	
	public static final Logger logger = Logger.getLogger(TreatmentLogCallType.class.getCanonicalName());
	
	public TreatmentLogCallType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.info(String.format("TreatmentLogCallType"));
		
		LogInfo datum = null;
		
		if (node.get("duration").isInt() 
				&& node.get("status_code").isTextual() 
				&& node.get("status_description").isTextual()) {
			datum = nextValidation.process(node);
		} else {
			statsMng.countFieldError();
		}
		
		return datum;
	}

}
