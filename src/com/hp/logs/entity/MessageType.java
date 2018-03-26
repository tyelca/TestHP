package com.hp.logs.entity;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MessageType {
	CALL, MSG;
	
	public static MessageType fromValue(JsonNode node) throws IOException {
		String value = node.asText();

		for (MessageType c: MessageType.values()) {
			if (c.name().equalsIgnoreCase(value)) {
				return c;
			}
		}
		
		throw new IOException (String.format("Message Type - Incorrect value : %s", value));        
	}
	
}
