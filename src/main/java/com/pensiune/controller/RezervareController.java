package com.pensiune.controller;

import com.pensiune.model.Rezervare;
import com.pensiune.service.RezervareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rezervari")
public class RezervareController {
    private final RezervareService rezervareService;

    public RezervareController(RezervareService rezervareService) {
        this.rezervareService = rezervareService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Rezervare>> getRezervariByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(rezervareService.getRezervariByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<Rezervare> addRezervare(@RequestBody Rezervare rezervare) {
        return ResponseEntity.ok(rezervareService.addRezervare(rezervare));
    }
}

