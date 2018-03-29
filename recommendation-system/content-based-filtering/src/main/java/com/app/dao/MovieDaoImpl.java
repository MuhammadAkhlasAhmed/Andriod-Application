package com.app.dao;

import com.app.logger.CustomLogger;
import com.app.service.MovieServiceImpl;
import org.springframework.stereotype.Component;

/**
 * DAO implementation that manages database persistence in Movie table
 */
@Component
public class MovieDaoImpl implements MovieDao {

    /**
     * Logger used for logging
     */
    private static final CustomLogger log = CustomLogger.createLogger(MovieDaoImpl.class);

}
