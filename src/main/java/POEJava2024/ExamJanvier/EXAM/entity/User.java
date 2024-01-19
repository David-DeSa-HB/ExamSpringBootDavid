package POEJava2024.ExamJanvier.EXAM.entity;

import POEJava2024.ExamJanvier.EXAM.json_views.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({
            JsonViews.ListingShow.class,
            JsonViews.UserShow.class
    })
    private Long id;

    @JsonView({
            JsonViews.ListingShow.class,
            JsonViews.UserShow.class
    })
    @CreationTimestamp
    private Date createdAt;

    @JsonView({
            JsonViews.ListingShow.class,
            JsonViews.UserShow.class
    })
    private String email;

    private String password;

    private String roles;

    @OneToMany(mappedBy = "user")
    @JsonView(JsonViews.UserShow.class)
    private List<Listing> listings = new ArrayList<>();
}
