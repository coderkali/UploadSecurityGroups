package com.gm.asm;

import com.gm.asm.service.ReadCSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
public class ConfigureAsmApplication implements CommandLineRunner {

	@Autowired
	ReadCSVService readCSVService;

	public static void main(String[] args) {
		SpringApplication.run(ConfigureAsmApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		readCSVService.readCSV();
	}
}
