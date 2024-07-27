package ar.com.laboratory.candidatesapi.infrastructure.controller.impl;


import ar.com.laboratory.candidatesapi.infrastructure.controller.HealthController;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
@AllArgsConstructor
@Slf4j
public class HealthControllerImpl implements HealthController {


    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Somehow I'm still alive...");
    }

}