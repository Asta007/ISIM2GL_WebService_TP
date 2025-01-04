package com.isi.ecommerce.msetudiant.Etudiant;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EtudiantService{

    private final EtudiantRepository etudiantRepository;

    public List<EtudiantEntity> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    public Optional<EtudiantEntity> getEtudiantById(Long id) {
        return etudiantRepository.findById(id);
    }


    public EtudiantEntity createEtudiant(EtudiantEntity etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public EtudiantEntity updateEtudiant(Long id, EtudiantEntity etudiantDetails) {
        Optional<EtudiantEntity> etudiant = etudiantRepository.findById(id)
                .map(element -> {
                    element.setNom(etudiantDetails.getNom());
                    element.setPrenom(etudiantDetails.getPrenom());
                    element.setEmail(etudiantDetails.getEmail());
                    element.setAdresse(etudiantDetails.getAdresse());
                    element.setTelephone(etudiantDetails.getTelephone());
                    element.setDateNaiss(etudiantDetails.getDateNaiss());
                    return etudiantRepository.save(element);
                });
        return etudiant.get();
    }

    public boolean deleteEtudiantById(Long id) {
        etudiantRepository.deleteById(id);
        return true;
    }
}
