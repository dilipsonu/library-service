package com.dk.library.test.common.stepdefs;


import com.dk.library.LibraryApplication;
//import org.springframework.boot.test.SpringApplicationContextLoader;
//import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

//@ContextConfiguration(classes = LibraryApplication.class, loader = SpringApplicationContextLoader.class)
//@WebIntegrationTest("server.port=8081")
@ContextConfiguration(classes = LibraryApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractDefs {
}
