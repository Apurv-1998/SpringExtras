package com.example.demo;

import java.lang.instrument.Instrumentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	public static void premain(String agentArgs, Instrumentation instrument) {
		instrument.addTransformer(null);
	}

	/*
	 * public int calculate(int number) {
	 * 
	 * probe[0] = true; // JaCoCo added this
	 * 
	 * if (number > 0) {
	 * probe[1] = true; // JaCoCo added this
	 * return number * 2;
	 * }
	 * 
	 * probe[2] = true; // JaCoCo added this
	 * 
	 * return 0;
	 * }
	 */

}