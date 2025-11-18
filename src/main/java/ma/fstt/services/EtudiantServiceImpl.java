package ma.fstt.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.fstt.entities.Etudiant;
import ma.fstt.repository.EtudiantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EtudiantServiceImpl implements EtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Override
    public List<Etudiant> findAll(){
        return etudiantRepository.findAll();
    }

    @Override
   public Etudiant findById(Long Id){
        return etudiantRepository.findById(Id).orElse(null);
    }

    @Override
    public List<Etudiant> findByClassId(Long classeId){
        return etudiantRepository.findByClasseId(classeId);

    }

    @Override
    public Etudiant save(Etudiant etudiant){
        return etudiantRepository.save(etudiant);

    }

    @Override
    public void deleteById(Long Id){
        etudiantRepository.deleteById(Id);
    }
}
