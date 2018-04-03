package com.hp.logs.treatment.message;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.entity.MessageStatusType;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentMessageStatusType extends TreatmentHandler {

	public static final Logger logger = LogManager.getLogger(TreatmentMessageStatusType.class.getCanonicalName());

	public TreatmentMessageStatusType(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {

		logger.debug(String.format("TreatmentMessageStatusType - Node = %s", node.toString()));

		LogInfo datum = null;

		try {
			MessageStatusType.fromValue(node.get("message_status"));

			datum = nextValidation.process(node);

		} catch (IOException e) {
			statsMng.countFieldError();
		}

		return datum;
	}

}
