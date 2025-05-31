package com.formula.bet.respository;

import com.formula.bet.model.EventOutcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventOutcomeRepository extends JpaRepository<EventOutcome, Long> {

}
