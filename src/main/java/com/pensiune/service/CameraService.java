package com.pensiune.service;

import com.pensiune.model.Camera;
import com.pensiune.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CameraService {

    @Autowired
    private CameraRepository cameraRepository;

    public List<Camera> getAllCamere() {
        return cameraRepository.findAll();
    }

    public Optional<Camera> getCameraById(Long id) {
        return cameraRepository.findById(id);
    }

    public Camera addCamera(Camera camera) {
        return cameraRepository.save(camera);
    }

    public Camera updateCamera(Long id, Camera cameraDetails) {
        return cameraRepository.findById(id).map(camera -> {
            camera.setNumarCamera(cameraDetails.getNumarCamera());
            camera.setTipCamera(cameraDetails.getTipCamera());
            camera.setPretPeNoapte(cameraDetails.getPretPeNoapte());
            camera.setDisponibila(cameraDetails.isDisponibila());
            return cameraRepository.save(camera);
        }).orElseThrow(() -> new RuntimeException("Camera nu a fost găsită!"));
    }

    public void deleteCamera(Long id) {
        cameraRepository.deleteById(id);
    }
}


