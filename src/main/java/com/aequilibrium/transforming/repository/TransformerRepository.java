package com.aequilibrium.transforming.repository;

import com.aequilibrium.transforming.entity.TransformerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransformerRepository extends JpaRepository<TransformerEntity, Long> {
}
