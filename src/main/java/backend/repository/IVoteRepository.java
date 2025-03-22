package backend.repository;

import backend.entity.Vote;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IVoteRepository extends CrudRepository<Vote, Long> {

}
