package com.demo;


import com.demo.objects.Communication;
import com.demo.objects.Starter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.demo.entity")
@EnableJpaRepositories("com.demo.repository")
@SpringBootApplication
public class MyApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(MyApp.class).web(WebApplicationType.NONE).run(args);
    }

    @Bean
    public CommandLineRunner runner(Communication communication) {
        return args -> communication.input();
    }


}

