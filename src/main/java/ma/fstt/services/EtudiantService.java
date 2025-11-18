package ma.fstt.services;

import ma.fstt.entities.Etudiant;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> findAll();
    Etudiant findById(Long Id);
    List<Etudiant> findByClassId(Long classeId);
    Etudiant save(Etudiant etudiant);
    void deleteById(Long Id);
}
