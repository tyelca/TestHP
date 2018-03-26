package com.hp.logs;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hp.logs.entity.CountryCode;
import com.hp.logs.entity.Statistic;
import com.hp.logs.entity.StatisticSummary;
import com.hp.logs.entity.StatusCodeType;

@Singleton
public class LogInfoStatisticManager {
	
	@Inject
	private Statistic statisticByFile;
	
	@Inject
	private StatisticSummary statisticSummary;

	
	public void countMissingFields() {
		statisticByFile.increaseRowsWithMissingFields(1);
	}
	
	public void countFieldError() {
		statisticByFile.increaseRowsWithFieldsError(1);
	}
	
	public void countCallsByStatusCode(StatusCodeType statusCode) {
		if (statusCode.equals(StatusCodeType.OK)) {
			statisticByFile.increaseCallsOK(1);
		} else {
			statisticByFile.increaseCallsKO(1);
		}	
	}
	
	public void countBlankContentMessage () {
		statisticByFile.increaseMessagesWithBlankContent(1);
	}
	
	public void countWordsFrequency (String msgContent) {
		String[] words = msgContent.split("\\s+");
		
		statisticByFile.addListWords(words);
	}
	
	public void countCallsByCountry (Long origin, int duration) {
		
		statisticByFile.addCountryCodeCall (CountryCode.fromMSISDN(origin), duration);
	}
	
	public void countProcessedFiles() {
		statisticSummary.increaseProcessedFilesCount(1);
	}
	
	public void countReadRows() {
		statisticSummary.increaseRowsCount(1);
	}
	
	public void countCallsCount () {
		statisticSummary.increaseCallsCount(1);
	}
	
	public void countMessagesCount() {
		statisticSummary.increaseMessageCount(1);
	}
	
	public void countOriginCountryCode (CountryCode countryCode) {
		statisticSummary.increaseOriginCountryCodeUniqueCount(countryCode);
	}
	
	public void countDestinationCountryCode (CountryCode countryCode) {
		statisticSummary.increaseDestinationCountryCodeUniqueCount(countryCode);
	}
	
	public void addDurationProcess (String fileName, Long duration) {
		statisticSummary.addDurationProcess(fileName, duration);
	}
	
	
	public Statistic getStatisticByFile() {
		return statisticByFile;
	}

	public StatisticSummary getStatisticSummary() {
		return statisticSummary;
	}
}
