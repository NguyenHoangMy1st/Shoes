package com.dnanh01.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {
	public static void main(String[] args) {

		SpringApplication.run(BackendApplication.class, args);
		System.out.println("\u001B[33m" + "App is working!!" + "\u001B[0m");
		System.out.println("\u001B[32m" + "App is working!!" + "\u001B[0m");
		System.out.println("\u001B[34m" + "App is working!!" + "\u001B[0m");
	}
}
