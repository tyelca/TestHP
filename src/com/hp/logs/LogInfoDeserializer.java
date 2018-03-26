package com.hp.logs;

import java.io.IOException;

import javax.inject.Singleton;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.entity.MessageType;
import com.hp.logs.treatment.TreatmentLogInfo;
import com.hp.logs.treatment.TreatmentLogInfoType;
import com.hp.logs.treatment.TreatmentMessageType;
import com.hp.logs.treatment.TreatmentOriginDestinationType;
import com.hp.logs.treatment.call.TreatmentLogCall;
import com.hp.logs.treatment.call.TreatmentLogCallType;
import com.hp.logs.treatment.call.TreatmentLogCallWellFormed;
import com.hp.logs.treatment.call.TreatmentStatusCodeType;
import com.hp.logs.treatment.message.TreatmentLogMessage;
import com.hp.logs.treatment.message.TreatmentLogMessageType;
import com.hp.logs.treatment.message.TreatmentLogMessageWellFormed;
import com.hp.logs.treatment.message.TreatmentMessageContent;
import com.hp.logs.treatment.message.TreatmentMessageStatusType;

@Singleton
public class LogInfoDeserializer extends JsonDeserializer<LogInfo>{

	private TreatmentLogInfo treatInfo;

		public LogInfoDeserializer (LogInfoStatisticManager statsMng) {
			this.statsMng = statsMng;	
		}

	
	private LogInfoStatisticManager statsMng;

	@Override
	public LogInfo deserialize(JsonParser parser, DeserializationContext ctx)
			throws IOException, JsonProcessingException {
		
		JsonNode node = parser.readValueAsTree();
		System.out.println("Nodo = " + node.toString());
		
		
		this.treatInfo = new TreatmentLogInfo(statsMng);
		

		TreatmentLogInfoType treatInfoType = new TreatmentLogInfoType(statsMng);
		TreatmentMessageType treatMsgType = new TreatmentMessageType(statsMng);
		
		TreatmentLogCall treatCall = new TreatmentLogCall(statsMng);
		TreatmentLogCallType treatCallType = new TreatmentLogCallType(statsMng);
		TreatmentOriginDestinationType treatOriginDestination = new TreatmentOriginDestinationType(statsMng);
		TreatmentStatusCodeType treatStatusCode = new TreatmentStatusCodeType(statsMng);
		TreatmentLogCallWellFormed treatCallFinal = new TreatmentLogCallWellFormed(statsMng);
		
		
		TreatmentLogMessage treatMsg = new TreatmentLogMessage(statsMng);
		TreatmentLogMessageType treatLogMsgType = new TreatmentLogMessageType(statsMng);
		TreatmentMessageStatusType treatMsgStatusType = new TreatmentMessageStatusType(statsMng);
		TreatmentMessageContent treatMsgContent = new TreatmentMessageContent(statsMng);
		TreatmentLogMessageWellFormed treatMsgFinal = new TreatmentLogMessageWellFormed(statsMng);
		
		
		treatInfo.setSuccessor(treatInfoType);
		treatInfoType.setSuccessor(treatMsgType);
		
		// Log CallTreatment Succession		
		treatCall.setSuccessor(treatCallType);
		treatCallType.setSuccessor(treatStatusCode);
		treatStatusCode.setSuccessor(treatOriginDestination);
		
		// Log Message Treatment Succession
		treatMsg.setSuccessor(treatLogMsgType);
		treatLogMsgType.setSuccessor(treatMsgStatusType);
		treatMsgStatusType.setSuccessor(treatMsgContent);
		treatMsgContent.setSuccessor(treatOriginDestination);
		
		if (node.has("message_type") && node.get("message_type").asText().equals(MessageType.CALL.name())) {
			treatMsgType.setSuccessor(treatCall);
			treatOriginDestination.setSuccessor(treatCallFinal);
		} else if (node.has("message_type") && node.get("message_type").asText().equals(MessageType.MSG.name())) {
			treatMsgType.setSuccessor(treatMsg);
			treatOriginDestination.setSuccessor(treatMsgFinal);
		} 
		
		
		
		return treatInfo.process (node);
		
   }
}