package hiq.leapproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class TestRepositoryRunner implements CommandLineRunner {

    private final QualityFormRepository repository;

    @Override
    public void run(String... args) throws Exception {

        // Hämta alla och skriv ut
        repository.findAll().forEach(System.out::println);
    }
}
