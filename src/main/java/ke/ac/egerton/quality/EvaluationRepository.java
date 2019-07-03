package ke.ac.egerton.quality;

import ke.ac.egerton.quality.entity.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluate,Long> {
}
