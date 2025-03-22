package backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment extends Post{

    @Id
    @Column(name = "idComment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idBug", nullable = false)
    private Bug bug;

    public Comment() {
    }

    public Comment(String text, String date, String imageURL, User user,Bug bug) {
        super(text, imageURL, date);
        this.user = user;
        this.bug = bug;
    }
}
