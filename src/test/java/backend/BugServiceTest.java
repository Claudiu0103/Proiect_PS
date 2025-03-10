package backend;

import backend.entity.Bug;
import backend.entity.User;
import backend.repository.BugRepository;
import backend.repository.UserRepository;
import backend.service.BugService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BugServiceTest {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BugService bugService;

    private User user;

    @BeforeEach
    void setUp() {
        bugRepository.deleteAll();
        userRepository.deleteAll();
        user = new User("testUser", "password123", false, 0.0, "USER");
        user = userRepository.save(user);
    }

    @Test
    void testInsertBug() {
        Bug bug = new Bug();
        bug.setTitle("Eroare Backend");
        Bug savedBug = bugService.insertBug(bug, user.getIdUser());

        assertNotNull(savedBug);
        assertEquals("Eroare Backend", savedBug.getTitle());
        assertEquals(user.getIdUser(), savedBug.getUser().getIdUser());
    }
}