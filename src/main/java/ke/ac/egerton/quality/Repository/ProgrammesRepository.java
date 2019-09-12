package ke.ac.egerton.quality.Repository;

import ke.ac.egerton.quality.model.Programmes;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProgrammesRepository extends JpaRepository<Programmes,Integer> {
}
