package com.hp.logs.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hp.logs.DetailCallSerializer;

@JsonSerialize (using=DetailCallSerializer.class)
public class DetailCall {

	private Long callOriginCount = 0L;
	private Long callDurationAddition = 0L;
	private Double callDurationAvg = 0D;
	
	public DetailCall(Long callCount, int callDurationAddition) {
		super();
		this.callOriginCount += callCount;
		this.callDurationAddition += callDurationAddition;
		this.callDurationAvg += Double.valueOf (this.callDurationAddition / this.callOriginCount);
	}

	@JsonProperty("callOriginCount") 
	public Long getCallOriginCount() {
		return callOriginCount;
	}

	public void addCallOriginCount(Long callCount) {
		this.callOriginCount += callCount;
		this.callDurationAvg = Double.valueOf (this.callDurationAddition / this.callOriginCount);
	}
	
	public Long getCallDurationAddition() {
		return callDurationAddition;
	}

	public void addCallDurationAddition(int callDurationAddition) {
		this.callDurationAddition += callDurationAddition;
		this.callDurationAvg = Double.valueOf (this.callDurationAddition / this.callOriginCount);
	}

	@JsonProperty("callDurationAvg") 
	public Double getCallDurationAvg() {
		return callDurationAvg;
	}
	
}
