package com.dk.library.test.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Slf4j
public class H2DataSourceConfiguration {

    @Bean
    public DataSource dataSource()  {

            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            return builder
                    .setType(EmbeddedDatabaseType.H2)
                    .addScript("sql/create_tables_script.sql")
                    .addScript("sql/insert_entries_script.sql")
                    .build();
    }

}
