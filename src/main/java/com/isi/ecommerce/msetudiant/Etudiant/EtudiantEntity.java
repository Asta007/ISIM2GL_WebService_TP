package com.isi.ecommerce.msetudiant.Etudiant;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "etudiant")
public class EtudiantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = true, unique = false)
    private String nom;
    @Column(nullable = true, unique = false)
    private String prenom;
    @Column(nullable = true, unique = false)
    private String adresse;
    @Column(nullable = true, unique = false)
    private String email;
    @Column(nullable = true, unique = true)
    private String telephone;
    @Column(nullable = true, unique = false)
    private Date dateNaiss;
    @Column(nullable = true, unique = false)
    private String sexe;
}
