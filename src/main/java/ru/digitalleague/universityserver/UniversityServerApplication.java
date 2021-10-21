package ru.digitalleague.universityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.digitalleague.universityserver.config.ApplicationConfiguration;

@SpringBootApplication
@Import(ApplicationConfiguration.class)
public class UniversityServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UniversityServerApplication.class, args);
    }

}
