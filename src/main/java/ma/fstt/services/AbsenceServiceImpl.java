package ma.fstt.services;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.fstt.entities.Absence;
import ma.fstt.repository.AbsenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AbsenceServiceImpl implements AbsenceService {

    private final AbsenceRepository absenceRepository;

    @Override
    public List<Absence> findAll(){
        return absenceRepository.findAll();
    }

    @Override
    public Absence findById(Long id) {
        return absenceRepository.findById(id).orElse(null);

    }

    @Override
   public  Absence save(Absence absence){
        return absenceRepository.save(absence);
    }

    @Override
    public void deleteById(Long Id){
        absenceRepository.deleteById(Id);
    }

    @Override
    public List<Absence> findByEtudiantId(Long etudiantId) {
        return absenceRepository.findByEtudiantId(etudiantId);
    }


}
