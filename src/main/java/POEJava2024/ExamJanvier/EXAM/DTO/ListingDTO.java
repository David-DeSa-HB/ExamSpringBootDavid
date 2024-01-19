package POEJava2024.ExamJanvier.EXAM.DTO;

import POEJava2024.ExamJanvier.EXAM.entity.Model;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListingDTO {

    @NotNull
    private String title;

    @NotNull
    private Model model;

    @NotNull
    private String description;

    @NotNull
    private int producedYear;

    @NotNull
    private Long mileage;

    @NotNull
    private Double price;

    @NotNull
    private Date createdAt;

    private String image;
}
