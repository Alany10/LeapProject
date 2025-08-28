package hiq.leapproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QualityFormControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private QualityFormRepository repository;

    @Test
    void testCreateAndFetchQualityForm() {
        // Skapa nytt formulär
        QualityForm form = new QualityForm();
        form.setCustomer("Acme AB");
        form.setConsultant("Anna");
        form.setDate(LocalDate.now());
        form.setSatisfaction(8);
        repository.save(form);

        // Hämta alla via repository
        var allForms = repository.findAll();
        assertThat(allForms).isNotEmpty();

        // Testa GET via controller
        ResponseEntity<String> response = restTemplate.getForEntity("/qualityForm", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).contains("sent");
    }
}
