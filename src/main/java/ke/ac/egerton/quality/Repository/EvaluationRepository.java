package ke.ac.egerton.quality.Repository;

import ke.ac.egerton.quality.model.Evaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluate,Long> {
}
