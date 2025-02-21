package com.pensiune;

import com.pensiune.model.Camera;
import com.pensiune.repository.CameraRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PensiuneApplication {
    public static void main(String[] args) {
        SpringApplication.run(PensiuneApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(CameraRepository cameraRepository) {
        return args -> {
            cameraRepository.save(new Camera(1, "Dubla", 100.0, true, "Cameră dublă standard cu pat matrimonial."));
            cameraRepository.save(new Camera(2, "Dubla", 100.0, true, "Cameră dublă standard cu pat matrimonial."));
            cameraRepository.save(new Camera(3, "Dubla cu pat extra", 120.0, true, "Cameră dublă cu posibilitatea adăugării unui pat suplimentar."));
            cameraRepository.save(new Camera(4, "Dubla cu pat extra", 120.0, true, "Cameră dublă cu posibilitatea adăugării unui pat suplimentar."));
            cameraRepository.save(new Camera(5, "Tripla", 150.0, true, "Cameră triplă cu trei paturi single."));
            cameraRepository.save(new Camera(6, "Tripla", 150.0, true, "Cameră triplă cu trei paturi single."));
            cameraRepository.save(new Camera(7, "Dubla", 100.0, true, "Cameră dublă standard cu pat matrimonial."));
            cameraRepository.save(new Camera(8, "Apartament", 200.0, true, "Apartament spațios pentru 4 persoane, cu un dormitor și living."));
        };
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
