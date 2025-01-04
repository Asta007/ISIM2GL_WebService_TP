package com.isi.ecommerce.msetudiant.Etudiant;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("etudiant")

public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService){
        this.etudiantService = etudiantService;
    }

    @GetMapping("/")
    public ResponseEntity<List<EtudiantEntity>> getAllEtudiants() {
        return ResponseEntity.ok(etudiantService.getAllEtudiants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtudiantEntity> getEtudiantsById(@PathVariable long id) {
        Optional<EtudiantEntity>optionalEtudiant = etudiantService.getEtudiantById(id);
        return new ResponseEntity<>(optionalEtudiant.get(), HttpStatus.OK);
    }

    @PostMapping("/")
    public HttpStatus saveEtudiants(EtudiantEntity etudiant) {
        etudiantService.createEtudiant(etudiant);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/")
    public HttpStatus deleteEtudiants(long id) {
        etudiantService.deleteEtudiantById(id);
        return HttpStatus.OK;
    }

}
