package backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @Column(name = "idComment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    private String date;

    @Column(name = "imageURL")
    private String imageURL;

    @Column(name = "nrOfLikes")
    private Integer nrOfLikes;

    @Column(name = "nrOfDislikes")
    private Integer nrOfDislikes;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idBug", nullable = false)
    private Bug bug;

    public Comment() {
    }

    public Comment(String text, String date, String imageURL, Integer nrOfLikes, Integer nrOfDislikes, User user,Bug bug) {
        this.text = text;
        this.date = date;
        this.imageURL = imageURL;
        this.nrOfLikes = nrOfLikes;
        this.nrOfDislikes = nrOfDislikes;
        this.user = user;
        this.bug = bug;
    }
}
