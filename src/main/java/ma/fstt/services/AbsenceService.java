package ma.fstt.services;

import ma.fstt.entities.Absence;

import java.util.List;

public interface AbsenceService {

    List<Absence> findAll();
    Absence findById(Long Id);
    Absence save(Absence absence);
    void deleteById(Long Id);
    List<Absence> findByEtudiantId(Long etudiantId);
}
