package com.pensiune.service;

import com.pensiune.model.Rezervare;
import com.pensiune.repository.RezervareRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RezervareService {
    private final RezervareRepository rezervareRepository;

    public RezervareService(RezervareRepository rezervareRepository) {
        this.rezervareRepository = rezervareRepository;
    }

    public List<Rezervare> getRezervariByUserId(Long userId) {
        return rezervareRepository.findByUserId(userId);
    }

    public Rezervare addRezervare(Rezervare rezervare) {
        return rezervareRepository.save(rezervare);
    }
}
