package com.ebraegel.heavycats.jpa.repository;

import com.ebraegel.heavycats.model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WeightRepository extends JpaRepository<Weight, Long> {
    List<Weight> findByCatId(Long catId);
    Optional<Weight> findByIdAndCatId(Long id, Long postId);
}
