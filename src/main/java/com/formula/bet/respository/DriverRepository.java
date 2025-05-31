package com.formula.bet.respository;

import com.formula.bet.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

    Driver findByIdNumber(Integer idNumber);
}
