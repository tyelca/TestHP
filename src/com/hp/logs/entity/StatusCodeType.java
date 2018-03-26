package com.hp.logs.entity;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusCodeType {
	OK, KO;
	
	public static StatusCodeType fromValue(JsonNode node) throws IOException {
		String value = node.asText();

		for (StatusCodeType c: StatusCodeType.values()) {
			if (c.name().equalsIgnoreCase(value)) {
				return c;
			}
		}
		throw new IOException(String.format("Status Code - Incorrect value : %s", value));        
	}
}
