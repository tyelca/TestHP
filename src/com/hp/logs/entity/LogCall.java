package com.hp.logs.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LogCall extends LogInfo {

	private Integer duration;
	private String status_code;
	private String status_description;

	@JsonCreator
	public LogCall(@JsonProperty("message_type") String message_type, @JsonProperty("timestamp") Integer timestamp,
			@JsonProperty("origin") Long origin, @JsonProperty("destination") Long destination,
			@JsonProperty("duration") Integer duration, @JsonProperty("status_code") String status_code,
			@JsonProperty("status_description") String status_description) {
		super(message_type, timestamp, origin, destination);
		this.duration = duration;
		this.status_code = status_code;
		this.status_description = status_description;
	}

	public Integer getDuration() {
		return duration;
	}

	public String getStatus_code() {
		return status_code;
	}

	public String getStatus_description() {
		return status_description;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}

	public void setStatus_description(String status_description) {
		this.status_description = status_description;
	}

}
