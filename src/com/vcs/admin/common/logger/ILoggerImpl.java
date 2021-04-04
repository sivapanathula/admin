package com.vcs.admin.common.logger;

import org.apache.log4j.Logger;

public class ILoggerImpl implements ILogger {

	private Logger logger;

	public void debug(String message) {
		logger.debug(message);

	}

	public void error(String message) {
		logger.error(message);

	}

	public void fatal(String message) {
		logger.fatal(message);

	}

	public void info(String message) {
		logger.info(message);

	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void warn(String message) {
		logger.warn(message);

	}

	public void setLogger(java.util.logging.Logger logger) {
		// TODO Auto-generated method stub

	}

}
