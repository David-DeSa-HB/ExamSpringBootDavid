package POEJava2024.ExamJanvier.EXAM.rest_controller;

import POEJava2024.ExamJanvier.EXAM.DTO.BrandDTO;
import POEJava2024.ExamJanvier.EXAM.DTO.UserDTO;
import POEJava2024.ExamJanvier.EXAM.entity.Brand;
import POEJava2024.ExamJanvier.EXAM.entity.User;
import POEJava2024.ExamJanvier.EXAM.json_views.JsonViews;
import POEJava2024.ExamJanvier.EXAM.service.BrandService;
import POEJava2024.ExamJanvier.EXAM.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/user")
public class UserRestController {

    private UserService userService;

    @GetMapping(path = "/{id}")
    @JsonView(JsonViews.UserShow.class)
    public User show(@PathVariable Long id) {
        return userService.show(id);
    }

    @PostMapping
    @JsonView(JsonViews.UserShow.class)
    public User create(@Valid @RequestBody UserDTO dto) {
        return userService.persist(dto, null);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.UserShow.class)
    public User update(@Valid @RequestBody UserDTO dto, @PathVariable Long id) {
        return userService.persist(dto, id);
    }
}
