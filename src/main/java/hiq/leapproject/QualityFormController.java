package hiq.leapproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QualityFormController {

    private final QualityFormRepository repository;

    public QualityFormController(QualityFormRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/qualityForm")
    public String showForm(Model model) {
        model.addAttribute("qualityForm", new QualityForm());
        return "qualityForm";
    }

    @PostMapping("/qualityForm")
    public String submitForm(QualityForm qualityForm) {
        repository.save(qualityForm);
        return "sent";
    }
}
