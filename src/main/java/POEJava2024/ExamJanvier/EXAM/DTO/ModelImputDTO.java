package POEJava2024.ExamJanvier.EXAM.DTO;

import POEJava2024.ExamJanvier.EXAM.entity.Brand;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModelImputDTO {

    @NotNull
    private String name;

    @NotNull
    private Brand brand;

}
