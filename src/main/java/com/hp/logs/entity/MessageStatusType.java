package com.hp.logs.entity;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum MessageStatusType {
	DELIVERED, SEEN;
	
	
	public static MessageStatusType fromValue(JsonNode node) throws IOException {
		String value = node.asText();

		for (MessageStatusType c: MessageStatusType.values()) {
			if (c.name().equalsIgnoreCase(value)) {
				return c;
			}
		}
		throw new IOException(String.format("Message Status - Incorrect value : %s", value));        
	}
}