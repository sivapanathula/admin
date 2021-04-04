package com.vcs.admin.common.logger;

import java.util.logging.Logger;

public interface ILogger {

	void setLogger(Logger logger);

	void debug(String message);

	void info(String message);

	void warn(String message);

	void error(String message);

	void fatal(String message);
}
