package soft.uni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import soft.uni.entities.Game;

/**
 * Created by Venelin on 27.7.2017 г..
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
