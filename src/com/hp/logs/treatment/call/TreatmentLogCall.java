package com.hp.logs.treatment.call;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentLogCall extends TreatmentHandler {

	public static final Logger logger = Logger.getLogger(TreatmentLogCall.class.getCanonicalName());

	public TreatmentLogCall(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.info(String.format("TreatmentLogCall"));

		LogInfo datum = null;

		if (node.has("duration") && node.has("status_code") && node.has("status_description")) {
			datum = nextValidation.process(node);
		} else {
			statsMng.countMissingFields();
		}

		return datum;
	}

}
