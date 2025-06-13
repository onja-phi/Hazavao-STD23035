package com.hazavao.demo.endpoint.rest.controller.health;

import com.hazavao.demo.service.HazavaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HazavaoController {

    private final HazavaoService hazavaoService;

    public HazavaoController(HazavaoService hazavaoService) {
        this.hazavaoService = hazavaoService;
    }

    @GetMapping("/hazavao")
    public ResponseEntity<String> getDefinition(@RequestParam String teny) {
        try {
            String definition = hazavaoService.getDefinition(teny);
            return ResponseEntity.ok(definition);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la récupération de la définition : " + e.getMessage());
        }
    }
}


