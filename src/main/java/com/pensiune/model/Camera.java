package com.pensiune.model;

import jakarta.persistence.*;


@Entity
@Table(name = "camere")

public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private int numarCamera;

    @Column(nullable = false)
    private String tipCamera; // Exemplu: Single, Double, Apartment

    @Column(nullable = false)
    private double pretPeNoapte;

    @Column(nullable = false)
    private boolean disponibila = true; // Default: Disponibilă

    // Getters și Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumarCamera() {
        return numarCamera;
    }

    public void setNumarCamera(int numarCamera) {
        this.numarCamera = numarCamera;
    }

    public String getTipCamera() {
        return tipCamera;
    }

    public void setTipCamera(String tipCamera) {
        this.tipCamera = tipCamera;
    }

    public double getPretPeNoapte() {
        return pretPeNoapte;
    }

    public void setPretPeNoapte(double pretPeNoapte) {
        this.pretPeNoapte = pretPeNoapte;
    }

    public boolean isDisponibila() {
        return disponibila;
    }

    public void setDisponibila(boolean disponibila) {
        this.disponibila = disponibila;
    }
}

