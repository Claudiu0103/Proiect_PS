package backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name ="users")
public class User {

    @Id
    @Column(name="idUser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="banned")
    private Boolean banned;

    @Column(name="score")
    private Double score;

    @Column(name="role")
    private String role;

    public User() {
    }

    public User(String username, String password, Boolean banned, Double score, String role) {
        this.username = username;
        this.password = password;
        this.banned = banned;
        this.score = score;
        this.role = role;
    }
}
