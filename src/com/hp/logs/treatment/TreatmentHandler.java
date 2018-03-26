package com.hp.logs.treatment;

import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.entity.LogInfo;

public abstract class TreatmentHandler {

	protected LogInfoStatisticManager statsMng;
	
	public TreatmentHandler (LogInfoStatisticManager statsMng) {
		this.statsMng = statsMng;
	}
	
	protected TreatmentHandler nextValidation;

	public void setSuccessor(TreatmentHandler successor) {
		nextValidation = successor;
	}

	public abstract LogInfo process(JsonNode node);
}
