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
    private String tipCamera;

    @Column(nullable = false)
    private double pretPeNoapte;

    @Column(nullable = false)
    private boolean disponibila = true; // Default: Disponibilă

    @Column(length = 500)
    private String descriere;

    public Camera(int i, String dublaCuPatExtra, double v, boolean b, String s) {
        this.numarCamera = i;
        this.tipCamera = dublaCuPatExtra;
        this.pretPeNoapte = v;
        this.disponibila = b;
        this.descriere = s;
    }
    public Camera() {
        this.tipCamera = "Necunoscut";
    }

    public Camera(int numarCamera, String tipCamera, double pretPeNoapte, boolean disponibila) {
        this.numarCamera = numarCamera;
        this.tipCamera = tipCamera;
        this.pretPeNoapte = pretPeNoapte;
        this.disponibila = disponibila;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

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
        if (tipCamera == null || tipCamera.isEmpty()){
            throw new IllegalArgumentException("tipul camerei nu poate fi gol");
        }
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

