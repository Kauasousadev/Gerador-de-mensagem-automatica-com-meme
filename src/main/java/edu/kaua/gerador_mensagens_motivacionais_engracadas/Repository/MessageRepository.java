package edu.kaua.gerador_mensagens_motivacionais_engracadas.Repository;

import edu.kaua.gerador_mensagens_motivacionais_engracadas.model.MotivationalMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;
import java.util.Random;

@Repository
public interface MessageRepository extends JpaRepository<MotivationalMessage, Integer> {

    @Query(value = "SELECT * FROM MotivationalMessage ORDER BY RAND() LIMIT 1", nativeQuery = true)
    MotivationalMessage findAllOrderByRandom();
}
