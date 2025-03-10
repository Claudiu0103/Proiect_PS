package backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTag;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "tag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BugTag> bugTags;
}
