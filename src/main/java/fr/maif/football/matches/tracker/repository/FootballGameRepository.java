package fr.maif.football.matches.tracker.repository;

import fr.maif.football.matches.tracker.model.FootballGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballGameRepository extends JpaRepository<FootballGame, String> {
}
