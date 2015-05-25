package org.testingzone;


import org.spring4gwt.server.SpringGwtRemoteServiceServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.testingzone.config.DataAccessConfig;

@Configuration
@ComponentScan(basePackages = {"org.testingzone"})
@Import(DataAccessConfig.class)
@SpringBootApplication
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ServletRegistrationBean springGwtServlet() {
        return new ServletRegistrationBean(new SpringGwtRemoteServiceServlet(), "/services/*");
    }
}
