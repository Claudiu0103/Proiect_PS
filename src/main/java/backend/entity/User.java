package backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name ="users")
public class User {

    @Id
    @Column(name="id_user")
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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bug> bugs = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

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
