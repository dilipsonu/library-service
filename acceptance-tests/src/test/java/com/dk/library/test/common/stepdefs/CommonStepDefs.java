package com.dk.library.test.common.stepdefs;

import com.jayway.restassured.RestAssured;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class CommonStepDefs {

    public static final String BASE_PATH = "/sourcing";

    private static final String VALID_USERNAME = "username";
    private static final String VALID_PASSWORD = "password";
    public static final String USERNAME_ATTR = "username";
    public static final String PASSWORD_ATTR = "password";

    private EmbeddedDatabase embeddedDatabase;


    @Before
    public void initRestAssured() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
    }



    @Before
    public void setUpDB() {
        embeddedDatabase = new EmbeddedDatabaseBuilder().setType(
                EmbeddedDatabaseType.H2).addScript(
                "sql/create_tables_script.sql").addScript(
                "sql/insert_entries_script.sql").build();
    }

    @After
    public void shutDownDB()
    {
        embeddedDatabase.shutdown();
    }
}
