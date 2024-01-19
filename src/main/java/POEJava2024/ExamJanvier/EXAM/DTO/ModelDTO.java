package POEJava2024.ExamJanvier.EXAM.DTO;

import POEJava2024.ExamJanvier.EXAM.entity.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModelDTO {

    @NotNull(message = "The date has to be a proper date")
    private String name;

    @NotNull(message = "The date has to be a proper date")
    private Brand brand;

}
