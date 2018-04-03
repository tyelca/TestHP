package com.hp.logs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LogMessage extends LogInfo {

	private String message_content;

	private String message_status;

	@JsonCreator
	public LogMessage(@JsonProperty("message_type") String message_type, @JsonProperty("timestamp") Integer timestamp,
			@JsonProperty("origin") Long origin, @JsonProperty("destination") Long destination,
			@JsonProperty("message_content") String message_content,
			@JsonProperty("message_status") String message_status) {
		super(message_type, timestamp, origin, destination);
		this.message_content = message_content;
		this.message_status = message_status;
	}

	public String getMessage_content() {
		return message_content;
	}

	public String getMessage_status() {
		return message_status;
	}

	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}

	public void setMessage_status(String message_status) {
		this.message_status = message_status;
	}

}
