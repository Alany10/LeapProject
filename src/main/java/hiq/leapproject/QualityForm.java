package hiq.leapproject;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class QualityForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customer;
    private String consultant;
    private String seller;

    private LocalDate date;
    private LocalDate consultantInformedDate;

    private String startup;
    private String result;

    // Dessa är textfält (kvalitativa kommentarer/bedömningar)
    private String responsibility;
    private String simplicity;
    private String joy;
    private String innovation;

    // Kvantitativa omdömen (1–10)
    private Integer satisfactionConsult;
    private Integer satisfactionCompany;

    private String improvements;
    private String valueAssessmentPositive;
    private String valueAssessmentNegative;

    private String other;
    private LocalDate nextFollowUp;

    public QualityForm() {}

    public void setSatisfactionConsult(Integer satisfactionConsult) {
        validateScore(satisfactionConsult);
        this.satisfactionConsult = satisfactionConsult;
    }

    public void setSatisfactionCompany(Integer satisfactionCompany) {
        validateScore(satisfactionCompany);
        this.satisfactionCompany = satisfactionCompany;
    }

    // Hjälpmetod för validering
    private void validateScore(Integer score) {
        if (score == null || score < 1 || score > 10) {
            throw new IllegalArgumentException("Måste vara mellan 1 och 10");
        }
    }
}
