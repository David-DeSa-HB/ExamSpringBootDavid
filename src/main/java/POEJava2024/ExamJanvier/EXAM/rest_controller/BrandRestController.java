package POEJava2024.ExamJanvier.EXAM.rest_controller;

import POEJava2024.ExamJanvier.EXAM.DTO.BrandDTO;
import POEJava2024.ExamJanvier.EXAM.entity.Brand;
import POEJava2024.ExamJanvier.EXAM.service.BrandService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/brand")
public class BrandRestController {

    private BrandService brandService;

    @GetMapping
    public List<Brand> list() {
        return brandService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Brand show(@PathVariable Long id) {
        return brandService.show(id);
    }

    @PostMapping
    public Brand create(@Valid @RequestBody BrandDTO dto) {
        return brandService.persist(dto, null);
    }

    @PutMapping("/{id}")
    public Brand update(@Valid @RequestBody BrandDTO dto, @PathVariable Long id) {
        return brandService.persist(dto, id);
    }
}
