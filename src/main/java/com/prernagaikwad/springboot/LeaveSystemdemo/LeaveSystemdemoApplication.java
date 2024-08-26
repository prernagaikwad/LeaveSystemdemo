package com.prernagaikwad.springboot.LeaveSystemdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LeaveSystemdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeaveSystemdemoApplication.class, args);
	}

}
