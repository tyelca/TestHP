package com.hp.logs.treatment.message;

import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.treatment.TreatmentHandler;

public class TreatmentMessageContent extends TreatmentHandler {
	
	public static final Logger logger = Logger.getLogger(TreatmentMessageContent.class.getCanonicalName());

	public TreatmentMessageContent(LogInfoStatisticManager statsMng) {
		super(statsMng);
	}

	@Override
	public LogInfo process(JsonNode node) {
			
		logger.info(String.format("TreatmentMessageContent"));
		
		String msgContent = node.get("message_content").asText();
		
		if (msgContent.isEmpty() || msgContent.trim().isEmpty()) {
			statsMng.countBlankContentMessage();
		} else {
			statsMng.countWordsFrequency (msgContent);
		}
		
		return nextValidation.process(node);
		
	}

}
