package ma.fstt.services;

import ma.fstt.entities.Classe;

import java.util.List;

public interface ClasseService {
    List<Classe> findAll();
    Classe findById(Long Id);
    Classe save(Classe classe);
    void deleteById(Long Id);

}
