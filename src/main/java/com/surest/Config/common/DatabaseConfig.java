package com.surest.Config.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties({
        DatabaseConfig.SuRestDBProperties.class,
        })
@EnableTransactionManagement
@EnableSpringDataWebSupport
public class DatabaseConfig{

    @Autowired
    private SuRestDBProperties suRestDBProperties;

    private static final String PROPERTY_DB_CACHE_PREPSTMTS = "dataSource.cachePrepStmts";
    private static final String PROPERTY_DB_PREPSTMT_CACHE_SIZE = "dataSource.prepStmtCacheSize";
    private static final String PROPERTY_DB_PREPSTMST_CACHE_SQLLIMIT = "dataSource.cachePrepStmts";

    private static final String VALUE_DB_CACHE_PREPSTMTS = "true";
    private static final String VALUE_DB_PREPSTMT_CACHE_SIZE = "250";
    private static final String VALUE_DB_PREPSTMST_CACHE_SQLLIMIT = "2048";



    @Bean (name="suRestDB")
    @Primary
    DataSource suRestDataSource() {
        return createDataSource(suRestDBProperties);
    }
    @Bean (name="suRestJdbc")
    @Primary
    JdbcTemplate suRestJdbcTemplate(DataSource suRestDataSource) {
        return new JdbcTemplate(suRestDataSource);
    }



    @ConfigurationProperties(prefix="spring.surest_datasource")
    public static class SuRestDBProperties extends DataSourceProperties{}



    DataSource createDataSource(DataSourceProperties properties) {
        HikariConfig dataSourceConfig = new HikariConfig();
        dataSourceConfig.setDriverClassName(properties.getDriverClassName());
        dataSourceConfig.setJdbcUrl(properties.getUrl());
        dataSourceConfig.setUsername(properties.getUsername());
        dataSourceConfig.setPassword(properties.getPassword());

        dataSourceConfig.addDataSourceProperty(PROPERTY_DB_CACHE_PREPSTMTS, VALUE_DB_CACHE_PREPSTMTS);
        dataSourceConfig.addDataSourceProperty(PROPERTY_DB_PREPSTMT_CACHE_SIZE, VALUE_DB_PREPSTMT_CACHE_SIZE);
        dataSourceConfig.addDataSourceProperty(PROPERTY_DB_PREPSTMST_CACHE_SQLLIMIT, VALUE_DB_PREPSTMST_CACHE_SQLLIMIT);
        return new HikariDataSource(dataSourceConfig);
    }


}
