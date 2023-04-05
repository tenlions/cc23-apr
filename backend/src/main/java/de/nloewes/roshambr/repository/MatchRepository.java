package de.nloewes.roshambr.repository;

import de.nloewes.roshambr.model.dao.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for {@link Match} objects
 *
 * @author nloewes
 */
@Repository
public interface MatchRepository extends JpaRepository<Match, String> {
}
