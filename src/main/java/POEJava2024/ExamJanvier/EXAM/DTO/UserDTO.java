package POEJava2024.ExamJanvier.EXAM.DTO;

import POEJava2024.ExamJanvier.EXAM.entity.Listing;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @PastOrPresent
    @NotNull
    private Date createdAt;

    @NotNull
    private String email;

    @NotNull(message = "Please, the password must have a value")
    @Size(message = "The password must have at least 8 characters", min = 8)
    private String password;

    @NotNull
    private String roles;

    private List<Listing> listings = new ArrayList<>();
}
