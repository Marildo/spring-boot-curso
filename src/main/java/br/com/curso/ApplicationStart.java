package br.com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
      //  makeToken();
        SpringApplication.run(ApplicationStart.class, args);
    }

    private static void makeToken() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String result = encoder.encode("admin123");
        System.out.println("my Hash:"+result);
    }
}
