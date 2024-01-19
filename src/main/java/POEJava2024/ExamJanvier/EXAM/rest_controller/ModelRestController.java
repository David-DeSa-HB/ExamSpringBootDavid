package POEJava2024.ExamJanvier.EXAM.rest_controller;

import POEJava2024.ExamJanvier.EXAM.DTO.ModelDTO;
import POEJava2024.ExamJanvier.EXAM.entity.Model;
import POEJava2024.ExamJanvier.EXAM.service.ModelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/model")
public class ModelRestController {

    private ModelService modelService;

    @GetMapping
    public List<Model> list() {
        return modelService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Model show(@PathVariable Long id) {
        return modelService.show(id);
    }

    @PostMapping
    public Model create(@Valid @RequestBody ModelDTO dto) {
        return modelService.persist(dto, null);
    }

    @PutMapping("/{id}")
    public Model update(@Valid @RequestBody ModelDTO dto, @PathVariable Long id) {
        return modelService.persist(dto, id);
    }
}
