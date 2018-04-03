package com.hp.logs.entity;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Statistic {

	private int rowsWithMissingFields = 0;

	private int messagesWithBlankContent = 0;

	private int rowsWithFieldsError = 0;

	private int callsOK = 0;

	private int callsKO = 0;

	private Map<String, Long> mapWordsFreq = new HashMap<>();

	private Map<CountryCode, DetailCall> mapCountryCalls = new HashMap<>();

	@JsonProperty("rowsWithMissingFields")
	public int getRowsWithMissingFields() {
		return rowsWithMissingFields;
	}

	public void increaseRowsWithMissingFields(int rowsWithMissingFields) {
		this.rowsWithMissingFields += rowsWithMissingFields;
	}

	@JsonProperty("messagesWithBlankContent")
	public int getMessagesWithBlankContent() {
		return messagesWithBlankContent;
	}

	public void increaseMessagesWithBlankContent(int messagesWithBlankContent) {
		this.messagesWithBlankContent += messagesWithBlankContent;
	}

	@JsonProperty("rowsWithFieldsError")
	public int getRowsWithFieldsError() {
		return rowsWithFieldsError;
	}

	public void increaseRowsWithFieldsError(int rowsWithFieldsError) {
		this.rowsWithFieldsError += rowsWithFieldsError;
	}

	@JsonProperty("callsOK")
	public int getCallsOK() {
		return callsOK;
	}

	public void increaseCallsOK(int callsOK) {
		this.callsOK += callsOK;
	}

	@JsonProperty("callsKO")
	public int getCallsKO() {
		return callsKO;
	}

	public void increaseCallsKO(int callsKO) {
		this.callsKO += callsKO;
	}

	@JsonProperty("mapWordsFreq")
	public Map<String, Long> getMapWordFreq() {
		return mapWordsFreq;
	}

	public void addListWords(String[] words) {
		for (int i = 0; i < words.length; i++) {
			addWord(words[i]);
		}
	}

	public void addWord(String word) {
		mapWordsFreq.put(word, mapWordsFreq.containsKey(word) ? mapWordsFreq.get(word) + 1L : 1L);
	}

	public void addCountryCodeCall(CountryCode countryCode, Integer duration) {

		DetailCall detail;

		if (mapCountryCalls.containsKey(countryCode)) {
			detail = mapCountryCalls.get(countryCode);
			detail.addCallOriginCount(1L);
			detail.addCallDurationAddition(duration);
		} else {
			detail = new DetailCall(1L, duration);
		}

		mapCountryCalls.put(countryCode, detail);
	}

	@JsonProperty("mapOriginCountryCalls")
	public Map<CountryCode, DetailCall> getMapCountryCalls() {
		return mapCountryCalls;
	}

}
