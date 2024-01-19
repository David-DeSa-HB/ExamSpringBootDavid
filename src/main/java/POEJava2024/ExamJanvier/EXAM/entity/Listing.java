package POEJava2024.ExamJanvier.EXAM.entity;

import POEJava2024.ExamJanvier.EXAM.json_views.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Listing {

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
    private String title;

    @JsonView(JsonViews.ListingShow.class)
    private String description;

    @JsonView(JsonViews.ListingShow.class)
    private int producedYear;

    @JsonView(JsonViews.ListingShow.class)
    private Long mileage;

    @JsonView(JsonViews.ListingShow.class)
    private Double price;

    @JsonView(JsonViews.ListingShow.class)
    private Date createdAt;

    @JsonView(JsonViews.ListingShow.class)
    private String image;

    @ManyToOne
    @JsonView(JsonViews.ListingShow.class)
    private Model model;

    @ManyToOne
    @JsonView(JsonViews.ListingShow.class)
    private User user;
}
