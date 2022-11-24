package com.dev.strangerred;

import com.dev.strangerred.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfig.class)
public class StrangerRedApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrangerRedApplication.class, args);
    }

}
