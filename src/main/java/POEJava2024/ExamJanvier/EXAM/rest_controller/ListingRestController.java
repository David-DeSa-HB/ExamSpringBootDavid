package POEJava2024.ExamJanvier.EXAM.rest_controller;

import POEJava2024.ExamJanvier.EXAM.DTO.ListingDTO;
import POEJava2024.ExamJanvier.EXAM.entity.Listing;
import POEJava2024.ExamJanvier.EXAM.json_views.JsonViews;
import POEJava2024.ExamJanvier.EXAM.service.ListingService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/listing")
public class ListingRestController {

    private ListingService listingService;

    @GetMapping
    @JsonView(JsonViews.ListingShow.class)
    public List<Listing> list() {
        return listingService.findAll();
    }

    @GetMapping(path = "/{id}")
    @JsonView(JsonViews.ListingShow.class)
    public Listing show(@PathVariable Long id) {
        return listingService.show(id);
    }

    @PostMapping
    public Listing create(@Valid @RequestBody ListingDTO dto) {
        return listingService.persist(dto, null);
    }

    @PutMapping("/{id}")
    public Listing update(@Valid @RequestBody ListingDTO dto, @PathVariable Long id) {
        return listingService.persist(dto, id);
    }
}
