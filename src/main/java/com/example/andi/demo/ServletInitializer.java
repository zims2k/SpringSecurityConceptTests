package com.example.andi.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Initializes the {@link org.springframework.web.servlet.DispatcherServlet} with our servlets defined by
 * {@link org.springframework.web.bind.annotation.RestController}s in this project.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

}
