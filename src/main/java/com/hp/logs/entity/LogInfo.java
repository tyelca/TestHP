package com.hp.logs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonDeserialize (using=LogInfoDeserializer.class)
public abstract class LogInfo {

	private String message_type;
	private Integer timestamp;
	private Long origin;
	private Long destination;

	@JsonCreator
	public LogInfo(@JsonProperty("message_type") String message_type, @JsonProperty("timestamp") Integer timestamp,
			@JsonProperty("origin") Long origin, @JsonProperty("destination") Long destination) {
		this.message_type = message_type;
		this.timestamp = timestamp;
		this.origin = origin;
		this.destination = destination;
	}

	public String getMessageType() {
		return message_type;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public Long getOrigin() {
		return origin;
	}

	public Long getDestination() {
		return destination;
	}

	public String getMessage_type() {
		return message_type;
	}

	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	public void setOrigin(Long origin) {
		this.origin = origin;
	}

	public void setDestination(Long destination) {
		this.destination = destination;
	}

}
