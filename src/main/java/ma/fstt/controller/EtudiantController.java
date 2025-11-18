package ma.fstt.controller;


import lombok.RequiredArgsConstructor;
import ma.fstt.entities.Etudiant;
import ma.fstt.services.ClasseService;
import ma.fstt.services.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/etudiants")
@RequiredArgsConstructor
public class EtudiantController {
    private final EtudiantService etudiantService;
    private final ClasseService classeService;


    @GetMapping
    public String list(Model model){
        model.addAttribute("etudiants", etudiantService.findAll());
        return "etudiants/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        model.addAttribute("classes", classeService.findAll());
        return "etudiants/form";
    }
    // Formulaire édition
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Etudiant etudiant = etudiantService.findById(id);
        if (etudiant == null) {
            return "redirect:/etudiants";
        }
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("classes", classeService.findAll());
        return "etudiants/form";
    }

    // Enregistrer (ajout + modification)
    @PostMapping("/save")
    public String save(
            @RequestParam(required = false) Long id_etu,
            @RequestParam String nom,
            @RequestParam String prenom,
            @RequestParam String dateNaissance,
            @RequestParam String sexe,
            @RequestParam String nomParent,
            @RequestParam String telephoneParent,
            @RequestParam String photo,              // ← URL de l'image (ex: images/ali.jpg)
            @RequestParam Long classeId) {

        Etudiant etudiant;

        if (id_etu != null && id_etu > 0) {
            etudiant = etudiantService.findById(id_etu);
            if (etudiant == null) {
                etudiant = new Etudiant();
            }
        } else {
            etudiant = new Etudiant();
        }

        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setDateNaissance(java.time.LocalDate.parse(dateNaissance));
        etudiant.setSexe(sexe);
        etudiant.setNomParent(nomParent);
        etudiant.setTelParent(telephoneParent);
        etudiant.setPhoto(photo); // ← on stocke juste le chemin
        etudiant.setClasse(classeService.findById(classeId));

        etudiantService.save(etudiant);
        return "redirect:/etudiants";
    }

    // Supprimer
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        etudiantService.deleteById(id);
        return "redirect:/etudiants";
    }
}
