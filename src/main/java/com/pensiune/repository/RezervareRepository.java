package com.pensiune.repository;

import com.pensiune.model.Rezervare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RezervareRepository extends JpaRepository<Rezervare, Long> {
    List<Rezervare> findByUserId(Long userId);
}
