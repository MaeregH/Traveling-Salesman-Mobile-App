package com.tco.misc;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CredentialTest {

    private static final Logger log = LoggerFactory.getLogger(CredentialTest.class);

    @BeforeAll
    public static void setup() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            fail("MariaDB JDBC Driver not found.");
        }
    }

    @Test
    @DisplayName("cortega2 : Make sure USER is correct")
    public void testUser() {
        assertEquals("cs314-db", Credential.user(), "USER should be 'cs314-db'");
    }

    @Test
    @DisplayName("cortega2 : Make sure PASSWORD is correct")
    public void testPassword() {
        assertEquals("eiK5liet1uej", Credential.password(), "PASSWORD should be 'eiK5liet1uej'");
    }

    @Test
    @DisplayName("cortega2 : Make sure URl isn't null and that it is correct ")
    public void testURL() {
        String url = Credential.url();
        assertNotNull(url, "URL should not be null");
        assertTrue(
            url.equals("jdbc:mariadb://faure.cs.colostate.edu/cs314") ||
            url.equals("jdbc:mariadb://127.0.0.1:31471/cs314"),
            "URL should be either the main URL or the SSH local URL"
        );
    }
}
