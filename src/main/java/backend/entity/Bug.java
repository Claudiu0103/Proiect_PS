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
    public class Bug extends Post {

        @Id
        @Column(name="idBug")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idBug;

        @Column(name = "title")
        private String title;

        @Column(name="status")
        private String status;

        @ManyToOne
        @JoinColumn(name = "idUser", nullable = false)
        private User user;

        @OneToMany(mappedBy = "bug", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Comment> comments = new ArrayList<>();

        @OneToMany(mappedBy = "bug", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<BugTag> bugTags = new ArrayList<>();

        public Bug() {}

        public Bug(String title, String text, String date, String status, String imageURL, User user) {
            super(text,imageURL,date);
            this.title = title;
            this.status = status;
            this.user = user;
        }

    }
