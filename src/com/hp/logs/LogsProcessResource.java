package com.hp.logs;

import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.hp.logs.entity.Statistic;
import com.hp.logs.entity.StatisticSummary;

@Path("/")
@ApplicationScoped
public class LogsProcessResource {

	public static final Logger logger = Logger.getLogger(LogsProcessResource.class.getCanonicalName());

	@Inject
	private LogService prueba;

	@GET
	@Path("{date : (20\\d{2})(\\d{2})(\\d{2})}")
	public Response geLogFile(@PathParam("date") String dateYYYYMMDD) {
		logger.info(String.format("Looking for log file: %s", dateYYYYMMDD));
		Response response;

		try {

			Boolean selected = prueba.selectFile(dateYYYYMMDD);
			response = selected ? Response.ok(selected).build() : Response.status(Status.NOT_FOUND).build();
		} catch (Exception e) {
			response = Response.status(Status.NOT_FOUND).build();
		}

		return response;
	}

	@GET
	@Path("metrics")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStatisticsBySelectedJson() {

		Statistic stats = prueba.calculateStatistics();

		if (stats != null) {
			return Response.ok(stats).build();
		} else {
			return Response.status(422).build(); // Unprocessable Entity
		}

	}

	@GET
	@Path("kpis")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGeneralStatistics() {
		logger.info("Statistics Summary");

		StatisticSummary statsSum = prueba.getGeneralStatistics();

		return Response.ok(statsSum).build();

	}

}
