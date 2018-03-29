package com.app.service;

import com.app.logger.CustomLogger;
import org.springframework.stereotype.Component;

/**
 * Service implementation that holds methods to be used by Resources
 *
 * @author ahayat
 */
@Component
public class MovieServiceImpl implements MovieService {

    /**
     * Logger used for logging
     */
    private static final CustomLogger log = CustomLogger.createLogger(MovieServiceImpl.class);

}
