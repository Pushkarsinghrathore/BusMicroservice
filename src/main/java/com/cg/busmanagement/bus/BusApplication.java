/****************************************************************************************************************************
 - File Name        : Bus Service Main
 - Author           : Pushkar Singh Rathore
 - Creation Date    : 13-06-2020
 - Description      : This is a main class for Bus service
  ****************************************************************************************************************************/ 

package com.cg.busmanagement.bus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cg")
public class BusApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusApplication.class, args);
	}

}
