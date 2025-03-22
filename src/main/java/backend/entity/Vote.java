package backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @Column(name = "idVote")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVote;

    @Column(name = "idUser", nullable = false)
    private Long idUser;

    @Column(name = "idComment")
    private Long idComment;

    @Column(name = "idBug")
    private Long idBug;


    @Column(name = "voteType", nullable = false)
    private VoteType voteType;

    public Vote() {
    }

    public Vote(Long idUser, Long idComment, Long idBug, VoteType voteType) {
        this.idUser = idUser;
        this.idComment = idComment;
        this.idBug = idBug;
        this.voteType = voteType;
    }
}
