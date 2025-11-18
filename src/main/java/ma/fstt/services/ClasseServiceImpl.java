package ma.fstt.services;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ma.fstt.entities.Classe;
import ma.fstt.repository.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClasseServiceImpl implements ClasseService {

    private final ClasseRepository classeRepository;

    @Override
    public List<Classe> findAll() {
        return classeRepository.findAll();
    }
    @Override
    public Classe save(Classe classe){
        return classeRepository.save(classe);
    }

    @Override
   public void deleteById(Long Id) {
        classeRepository.deleteById(Id);
    }

   @Override
    public Classe findById(Long Id) {
       return classeRepository.findById(Id).orElse(null);
   }
}
