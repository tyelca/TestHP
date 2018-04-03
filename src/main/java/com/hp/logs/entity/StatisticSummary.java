package com.hp.logs.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticSummary {
	
	private int processedFilesCount = 0;
	
	private int rowsCount = 0;
	
	private int callsCount = 0;
	
	private int messageCount = 0;
	
	private Set<CountryCode> setOriginCountryCode = new HashSet<>();

	private Set<CountryCode> setDestinationCountryCode = new HashSet<>();
	
	private Map<String, Long> mapDuracionJsonProcess = new HashMap<>();

	
	@JsonProperty("processedFilesCount")
	public int getProcessedFilesCount() {
		return processedFilesCount;
	}
	
	public void increaseProcessedFilesCount (int count) {
		this.processedFilesCount += count;
	}

	@JsonProperty("rowsCount")
	public int getRowsCount() {
		return rowsCount;
	}

	public void increaseRowsCount (int count) {
		this.rowsCount += count;
	}

	@JsonProperty("callsCount")
	public int getCallsCount() {
		return callsCount;
	}
	
	public void increaseCallsCount (int count) {
		this.callsCount += count;
	}
	

	@JsonProperty("messageCount")
	public int getMessageCount() {
		return messageCount;
	}
	
	public void increaseMessageCount (int count) {
		this.messageCount += count;
	}

	@JsonProperty("originCountryCodeUniqueCount")
	public int getOriginCountryCodeUniqueCount() {
		return setOriginCountryCode.size();
	}
	
	public void increaseOriginCountryCodeUniqueCount (CountryCode countryCode) {
		setOriginCountryCode.add(countryCode);
	}

	@JsonProperty("destinationCountryCodeUniqueCount")
	public int getDestinationCountryCodeUniqueCount() {
		return setDestinationCountryCode.size();
	}
	
	public void increaseDestinationCountryCodeUniqueCount (CountryCode countryCode) {
		setDestinationCountryCode.add(countryCode);
	}

	@JsonProperty("mapDuracionInMsJsonProcess")
	public Map<String, Long> getMapDuracionJsonProcess() {
		return mapDuracionJsonProcess;
	}
	
	public void addDurationProcess (String fileName, Long duration) {
		mapDuracionJsonProcess.put(fileName, duration);
	}

}
