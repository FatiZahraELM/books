package fr.norsys.gestionlivresapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.mappers.ModelMapper;

@SpringBootApplication
public class GestionLivresApiApplication {


    public static void main(String[] args) {
        SpringApplication.run(GestionLivresApiApplication.class, args);
    }

}
