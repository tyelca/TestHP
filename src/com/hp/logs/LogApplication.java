package com.hp.logs;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.hp.configure.LogApplicationBinder;

@ApplicationPath("/api") // Servlet
public class LogApplication extends ResourceConfig {
	
	public LogApplication () {
		register (new LogApplicationBinder());
		packages (true, "com.hp.logs");
		
	}
	
	

	
	
}
