package com.hp.configure;


import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.hp.logs.LogInfoDeserializer;
import com.hp.logs.LogInfoStatisticManager;
import com.hp.logs.LogService;
import com.hp.logs.entity.Statistic;
import com.hp.logs.entity.StatisticSummary;

public class LogApplicationBinder extends AbstractBinder {

	@Override
	protected void configure() {
		bind (LogService.class).to(LogService.class).in(Singleton.class);
		bind (LogInfoStatisticManager.class).to (LogInfoStatisticManager.class).in(Singleton.class);
		bind (Statistic.class).to(Statistic.class);
		bind (StatisticSummary.class).to(StatisticSummary.class);
		bind (LogInfoDeserializer.class).to(LogInfoDeserializer.class).in(Singleton.class);

	}

}
