package com.aequilibrium.transforming.repository;

import com.aequilibrium.transforming.entity.TransformerTeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransformerTeamRepository extends JpaRepository<TransformerTeamEntity, Long> {

    TransformerTeamEntity findByTeamName(String teamName);
}
