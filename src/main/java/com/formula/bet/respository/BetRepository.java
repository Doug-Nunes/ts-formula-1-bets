package com.formula.bet.respository;

import com.formula.bet.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, Long> {

    List<Bet> findByEventSessionSessionKeyAndStatus(Integer sessionKey, String status);
}
