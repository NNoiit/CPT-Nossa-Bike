package com.aluguel.nossa_bike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aluguel.nossa_bike.models.ActivationLog;

@Repository
public interface ActivationRepository extends JpaRepository<ActivationLog, Integer>{
    
}
