package com.pcedu.sboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbootApplication {

	public static void main(String[] args) {
            String s = new String("Hello");
            System.out.println(s);
		SpringApplication.run(SbootApplication.class, args);
	}

}
