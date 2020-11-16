package com.ebraegel.heavycats.jpa.repository;

import com.ebraegel.heavycats.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

}
