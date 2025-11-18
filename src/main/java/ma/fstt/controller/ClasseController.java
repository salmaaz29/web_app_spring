package ma.fstt.controller;

import lombok.RequiredArgsConstructor;
import ma.fstt.entities.Classe;
import ma.fstt.services.ClasseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
@RequiredArgsConstructor
public class ClasseController {

    private final ClasseService classeService;

    @GetMapping
    public String lister(Model model) {
        model.addAttribute("classes", classeService.findAll());
        return "classes/list";

    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("classe", new Classe());
        return "classes/form";
    }

    @PostMapping("/save")
    public String save(@RequestParam(required = false) Long id_classe,@RequestParam String libelle,@RequestParam String niveau, @RequestParam String anneeScolaire ) {
        Classe classe;

        // SI on est en mode édition (id_classe existe)
        if (id_classe != null && id_classe > 0) {
            classe = classeService.findById(id_classe);
            if (classe == null) {
                classe = new Classe(); // sécurité
            }
        }
        // SINON on est en mode ajout
        else {
            classe = new Classe();
        }

        // On met à jour les champs
        classe.setLibelle(libelle);
        classe.setNiveau(niveau);
        classe.setAnneeScolaire(anneeScolaire);

        classeService.save(classe);   // INSERT ou UPDATE automatique

        return "redirect:/classes";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Classe classe = classeService.findById(id);


        if (classe == null) {
            return "redirect:/classes";
        }

        model.addAttribute("classe", classe);  // On envoie l'objet complet au formulaire
        return "classes/form";                 // même page que pour ajouter
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        classeService.deleteById(id);
        return "redirect:/classes";
    }



}
