package com.hp.logs.treatment;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;

public class TreatmentLogInfo extends TreatmentHandler {

	public static final Logger logger = Logger.getLogger(TreatmentLogInfo.class.getCanonicalName());

	public TreatmentLogInfo(LogInfoStatisticManager statsMng) {
		super(statsMng);

	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.info(String.format("TreatmentLogInfo"));

		
		LogInfo datum = null;

		if (node.has("message_type") && node.has("timestamp") && node.has("origin") && node.has("destination")) {
			datum = nextValidation.process(node);
		} else {
			statsMng.countMissingFields();
		}

		statsMng.countReadRows();
		return datum;
	}
}
