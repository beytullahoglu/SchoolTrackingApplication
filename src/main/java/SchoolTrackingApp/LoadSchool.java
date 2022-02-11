package SchoolTrackingApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration  
public class LoadSchool {
    private static final Logger log = LoggerFactory.getLogger(LoadSchool.class);

    @Bean
    CommandLineRunner initDatabase(SchoolRepository schoolRepository){

        return args -> {
            log.info("Preloading " + schoolRepository.save(new Student(1, "Tugra", "Beytullahoglu", 26, 285, 3.4)));
            log.info("Preloading " + schoolRepository.save(new Student(2, "Mumer", "Tan", 23, 450, 3.5)));
            log.info("Preloading " + schoolRepository.save(new Student(3, "Toc Abim", "Tozkoparan", 26, 167, 3.8)));
            log.info("Preloading " + schoolRepository.save(new Student(4, "Dubela", "DallaDatli", 25, 31, 3.8)));
            log.info("Preloading " + schoolRepository.save(new Teacher(5, "Ahmet", "Kaya", 58, "Molotof101")));
        };
    }
    
}
