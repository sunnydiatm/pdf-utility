package com.sunny.pdf.pdfutility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.sunny.pdf")
public class PdfUtilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(PdfUtilityApplication.class, args);
	}

}
