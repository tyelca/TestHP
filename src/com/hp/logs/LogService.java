package com.hp.logs;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.hp.logs.entity.LogInfo;
import com.hp.logs.entity.Statistic;
import com.hp.logs.entity.StatisticSummary;

@Singleton
public class LogService {

	private static final String TARGET_URL = "https://raw.githubusercontent.com/vas-test/test1/master/logs/";
	private static final String FILENAME_PREFFIX = "MCP_";
	private static final String FILENAME_SUFFIX = ".json";

	private String selectedFilePath = "";
	private String lastSelectedFile = "";

	public static final Logger logger = Logger.getLogger(LogService.class.getCanonicalName());

	private Client client;

	public LogService() {
		this.client = ClientBuilder.newClient(new ClientConfig().register(new LoggingFeature()));
		client.register(JacksonJsonProvider.class);
	}

	public Boolean selectFile(final String date) {
		this.selectedFilePath = new StringBuilder().append(TARGET_URL).append(FILENAME_PREFFIX).append(date)
				.append(FILENAME_SUFFIX).toString();

		Response response = client.target(selectedFilePath).request().accept(MediaType.TEXT_PLAIN).get();

		return response.getStatusInfo().getStatusCode() == Status.OK.getStatusCode() ? Boolean.TRUE : Boolean.FALSE;
	}

	@Inject
	private LogInfoStatisticManager statsManager;

	public Statistic calculateStatistics(/* LogInfoStatisticManager statsManager */) {

		Statistic statistic = null;

		if (!lastSelectedFile.equalsIgnoreCase(selectedFilePath)) {
			long timeMsIni = System.currentTimeMillis();

			List<LogInfo> beanList1 = readAllFile();

			if (beanList1 != null) {
				statistic = statsManager.getStatisticByFile();
				statsManager.addDurationProcess(this.selectedFilePath, System.currentTimeMillis() - timeMsIni);
				statsManager.countProcessedFiles();
			}

			this.lastSelectedFile = this.selectedFilePath;

		} else {
			statistic = statsManager.getStatisticByFile();
		}
		return statistic;

	}

	private List<LogInfo> readAllFile() {

		List<LogInfo> beanList1 = null;

		ObjectMapper mapper = new ObjectMapper();

		try {

			Response responseFoundFile = client.target(this.selectedFilePath).request().accept(MediaType.TEXT_PLAIN)
					.get();

			if (responseFoundFile.getStatusInfo().getStatusCode() == Status.OK.getStatusCode()) {
				String selectedfileContent = responseFoundFile.readEntity(String.class);

				// Crear un array de json y sustituye los retornos de carro por comas
				String jsonArray = new StringBuilder().append("[")
						.append(selectedfileContent.replaceAll("\\r?\\n", ",")).append("]").toString();

				/* Esto es equivalente a @JsonDeserializer */
				final SimpleModule module = new SimpleModule();
				module.addDeserializer(LogInfo.class, new LogInfoDeserializer(statsManager));
				mapper.registerModule(module);

				JavaType customClassCollection1 = mapper.getTypeFactory().constructCollectionType(List.class,
						LogInfo.class);
				beanList1 = mapper.readValue(jsonArray, customClassCollection1);
			}

		} catch (IOException e) {
			logger.info(String.format("Error parsing file. Details : %s", e.getMessage()));
		}

		return beanList1;
	}

	public StatisticSummary getGeneralStatistics() {
		return statsManager.getStatisticSummary();
	}

}
