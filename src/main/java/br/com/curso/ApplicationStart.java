package br.com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

/*
@EnableAutoConfiguration
@ComponentScan(basePackages = {"br.com.curso.*"})
@Configuration
 ou apenas @SpringBootApplication
 */


@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
