package backend.repository;

import backend.entity.Bug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBugRepository extends CrudRepository<Bug, Long> {
}
