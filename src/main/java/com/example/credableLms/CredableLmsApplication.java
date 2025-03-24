package com.example.credableLms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.example.credableLms")
@EnableJpaRepositories(basePackages = "com.example.credableLms.repository")
@EntityScan(basePackages = "com.example.credableLms.model")

public class CredableLmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CredableLmsApplication.class, args);
	}
}

@Component
class DatabaseConnectionTest implements CommandLineRunner {

	private final JdbcTemplate jdbcTemplate;

	public DatabaseConnectionTest(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			jdbcTemplate.execute("SELECT 1");
			System.out.println("✅ Successfully connected to the database!");
		} catch (Exception e) {
			System.err.println("❗ Database connection failed: " + e.getMessage());
		}
	}
}
