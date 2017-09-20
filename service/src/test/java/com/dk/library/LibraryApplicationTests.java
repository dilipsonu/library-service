package com.dk.library;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith (SpringJUnit4ClassRunner.class)
@SpringBootTest (classes = LibraryApplication.class)
@TestPropertySource ({"classpath:application-local.yml"})
@WebAppConfiguration
public class LibraryApplicationTests {

    @Test
    public void contextLoads() {
    }
}
