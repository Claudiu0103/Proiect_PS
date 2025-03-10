package backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name ="bugs")
public class Bug {

    @Id
    @Column(name="idBug")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBug;

    @Column(name = "title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="date")
    private String date;

    @Column(name="status")
    private String status;

    @Column(name="imageURL")
    private String imageURL;

    @Column(name="nrOfLikes")
    private Integer nrOfLikes;

    @Column(name="nrOfDislikes")
    private Integer nrOfDislikes;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @OneToMany(mappedBy = "bug", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "bug", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BugTag> bugTags = new ArrayList<>();

    public Bug() {}

    public Bug(String title, String text, String date, String status, String imageURL, Integer nrOfLikes, Integer nrOfDislikes, User user) {
        this.title = title;
        this.text = text;
        this.date = date;
        this.status = status;
        this.imageURL = imageURL;
        this.nrOfLikes = nrOfLikes;
        this.nrOfDislikes = nrOfDislikes;
        this.user = user;
    }
}
