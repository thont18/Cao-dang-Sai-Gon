package com.project.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.project.springboot.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class ProjectPetSpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectPetSpaApplication.class, args);
		System.out.println("Done!");
	}

}
