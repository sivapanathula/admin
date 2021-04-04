package com.vcs.admin.common.util.service;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import com.vcs.admin.common.logger.ILogger;
import com.vcs.admin.common.logger.ILoggerImpl;

final public class Log4jUtil {

	private Log4jUtil() {

	}

	static {

		DOMConfigurator.configure(Log4jUtil.class.getClassLoader().getResource(
				"/log4j.xml"));

	}

	public static ILogger getLogger(Class clas) {
		Logger logger = Logger.getLogger(clas);
		ILoggerImpl impl = new ILoggerImpl();
		impl.setLogger(logger);
		return impl;
	}
}