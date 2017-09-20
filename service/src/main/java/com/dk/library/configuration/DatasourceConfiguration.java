package com.dk.library.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

@Configuration
@ConfigurationProperties (prefix = "library.db")
@Setter
public class DatasourceConfiguration {

    private int maxPoolSize;
    private int minPoolSize;
    private int acquireIncrement;
    private int idleTestPeriod;
    private int maxStatements;
    private String jdbcUrl;
    private String username;
    private String password;
    private String driverClassName;

    @Bean
    public ComboPooledDataSource datasource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setMinPoolSize(minPoolSize);
        dataSource.setAcquireIncrement(acquireIncrement);
        dataSource.setIdleConnectionTestPeriod(idleTestPeriod);
        dataSource.setMaxStatements(maxStatements);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setPassword(password);
        dataSource.setUser(username);
        dataSource.setDriverClass(driverClassName);
        return dataSource;
    }
}
