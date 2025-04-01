package com.example.BestHospital;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.junit.jupiter.api.Assertions.*;
@Testcontainers
public class DatabaseContainerTest {
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:latest")
            .withDatabaseName("test_db")
            .withUsername("test")
            .withPassword("test");
    @Test
    public void testPostgresContainer() {
        postgreSQLContainer.start();
        assertTrue(postgreSQLContainer.isRunning(), "PostgreSQL container should be running");
    }
}
