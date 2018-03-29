package com.app.dao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for Database. It also provides DataSource bean for Database operations.
 *
 * @author ahayat
 */
@Configuration
public class DataSourceConfig {

    /**
     * Driver class name provided through application.properties
     */
    @Value("${db.driverClass}")
    private String driverClass;

    /**
     * JDBC URL of database provided through application.properties
     */
    @Value("${db.url}")
    private String jdbcUrl;

    /**
     * JDBC username of database provided through application.properties
     */
    @Value("${db.username}")
    private String userName;

    /**
     * JDBC password of database provided through application.properties
     */
    @Value("${db.password}")
    private String password;


    /**
     * Create DataSource bean to be registered in Spring-Context
     *
     * @return DataSource object
     * @throws Exception
     *             exception
     */
    @Bean
    public DataSource createDataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        return dataSource;
    }

}
