package ma.fstt.repository;

import ma.fstt.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findByEtudiantIdOrderByDateAbsenceDesc(Long etudiantId);

    List<Absence> findByEtudiantId(Long etudiantId);
}
