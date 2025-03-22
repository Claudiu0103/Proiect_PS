package backend.repository;

import backend.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepository extends CrudRepository<Comment, Long> {

}
