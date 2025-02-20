package com.pensiune.controller;

import com.pensiune.model.Camera;
import com.pensiune.service.CameraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Camere")
public class CameraController {
    private final CameraService cameraService;

    public CameraController(CameraService cameraService) {
        this.cameraService = cameraService;
    }

    @GetMapping
    public ResponseEntity<List<Camera>> getAllCamere() {
        return ResponseEntity.ok(cameraService.getAllCamere());
    }

    @PostMapping
    public ResponseEntity<Camera> addCamera(@RequestBody Camera camera) {
        return ResponseEntity.ok(cameraService.addCamera(camera));
    }
}

