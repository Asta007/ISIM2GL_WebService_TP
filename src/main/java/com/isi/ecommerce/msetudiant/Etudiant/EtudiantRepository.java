package com.isi.ecommerce.msetudiant.Etudiant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<EtudiantEntity,Long> {
}
