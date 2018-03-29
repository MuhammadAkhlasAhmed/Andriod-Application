package com.app.logger;

import org.apache.log4j.Logger;

public class CustomLogger {
    private Logger myLog = null;

    private CustomLogger(Logger log) {
        this.myLog = log;
    }

    public static CustomLogger createLogger(Class c) {
        return new CustomLogger(Logger.getLogger(c));
    }

    public void debug(Object obj) {
        this.myLog.debug(obj);
    }

    public void debug(Object obj, Throwable throwable) {
        this.myLog.debug(obj, throwable);
    }

    public void error(Object obj) {
        this.myLog.error(obj);
    }

    public void error(Object obj, Throwable throwable) {
        this.myLog.error(obj, throwable);
    }

    public void fatal(Object obj) {
        this.myLog.fatal(obj);
    }

    public void fatal(Object obj, Throwable throwable) {
        this.myLog.fatal(obj, throwable);
    }

    public void warn(Object obj) {
        this.myLog.warn(obj);
    }

    public void warn(Object obj, Throwable throwable) {
        this.myLog.warn(obj, throwable);
    }

    public void info(Object obj) {
        this.myLog.info(obj);
    }

    public void info(Object obj, Throwable throwable) {
        this.myLog.info(obj, throwable);
    }

    public void trace(Object obj) {
        this.myLog.trace(obj);
    }

    public void trace(Object obj, Throwable throwable) {
        this.myLog.trace(obj, throwable);
    }

    public Logger getLogger() {
        return this.myLog;
    }
}
