package com.btc.sys.utils;

import org.apache.log4j.Logger;

public class LogUtil {

	private static Logger logger = Logger.getLogger("BTC");

	public static Logger getLogger() {
		if (logger != null) {
			return logger;
		} else {
			return Logger.getLogger("BTC");
		}
	}
}
