package com.pensiune.controller;

import com.pensiune.model.Camera;
import com.pensiune.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/camere")
@CrossOrigin(origins = "http://localhost:3000") // Permite accesul din frontend
public class CameraController {

    @Autowired
    private CameraService cameraService;

    @GetMapping
    public List<Camera> getAllCamere() {
        return cameraService.getAllCamere();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Camera> getCameraById(@PathVariable Long id) {
        Optional<Camera> camera = cameraService.getCameraById(id);
        return camera.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Camera addCamera(@RequestBody Camera camera) {
        return cameraService.addCamera(camera);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Camera> updateCamera(@PathVariable Long id, @RequestBody Camera cameraDetails) {
        try {
            Camera updatedCamera = cameraService.updateCamera(id, cameraDetails);
            return ResponseEntity.ok(updatedCamera);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCamera(@PathVariable Long id) {
        cameraService.deleteCamera(id);
        return ResponseEntity.noContent().build();
    }
}


