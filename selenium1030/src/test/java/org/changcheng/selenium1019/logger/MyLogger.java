package org.changcheng.selenium1019.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.changcheng.selenium1019.LogTest;

public class MyLogger {
	private Logger logger;
	
	public MyLogger(final Class<?> clazz) {
		logger = LogManager.getLogger(clazz);
	}
	
	public void trace(String message) {
		logger.trace(message);
	}
	
	public void debug(String message) {
		logger.debug(message);
	}
	
	public void info(String message) {
		logger.info(message);
	}
	
	public void warn(String message) {
		logger.warn(message);
	}
	
	public void error(String message) {
		logger.error(message);
	}
	
	public void fatal(String message) {
		logger.fatal(message);
	}

}
