package com.hp.logs.treatment;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;

public class TreatmentLogInfo extends TreatmentHandler {

	public static final Logger logger = LogManager.getLogger(TreatmentLogInfo.class.getCanonicalName());

	public TreatmentLogInfo(LogInfoStatisticManager statsMng) {
		super(statsMng);

	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.debug(String.format("TreatmentLogInfo - Node = %s", node.toString()));

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
