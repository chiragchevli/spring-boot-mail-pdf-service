package com.mailsender;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class MailPdfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailPdfServiceApplication.class, args);
	}
}
