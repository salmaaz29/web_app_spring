package ma.fstt.controller;

import lombok.RequiredArgsConstructor;
import ma.fstt.entities.Absence;
import ma.fstt.entities.Etudiant;
import ma.fstt.services.AbsenceService;
import ma.fstt.services.EtudiantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequiredArgsConstructor
@RequestMapping("/absences")
public class AbsenceController {

    private final AbsenceService absenceService;
    private final EtudiantService etudiantService;

    // Page principale : choisir un étudiant
    @GetMapping
    public String index(Model model) {
        model.addAttribute("etudiants", etudiantService.findAll());
        return "absences/index";
    }

    // Liste des absences d’un étudiant
    @GetMapping("/etudiant/{etudiantId}")
    public String listByEtudiant(@PathVariable Long etudiantId, Model model) {
        Etudiant etudiant = etudiantService.findById(etudiantId);
        if (etudiant == null) {
            return "redirect:/etudiants";
        }
        model.addAttribute("etudiant", etudiant);
        model.addAttribute("absences", absenceService.findByEtudiantId(etudiantId));
        model.addAttribute("nouvelleAbsence", new Absence());
        return "absences/list";
    }

    // Sauvegarde (ajout ou modification)
    @PostMapping("/save")
    public String save(
            @RequestParam(required = false) Long id_abs,
            @RequestParam Long etudiantId,
            @RequestParam LocalDate dateAbsence,
            @RequestParam(required = false) LocalTime heuredubet,
            @RequestParam(required = false) LocalTime heurefin,
            @RequestParam(required = false) String motif,
            @RequestParam(defaultValue = "false") boolean justifiee) {

        Absence absence;

        if (id_abs != null && id_abs > 0) {
            absence = absenceService.findById(id_abs);
            if (absence == null) {
                absence = new Absence();
            }
        } else {
            absence = new Absence();
        }

        absence.setDateAbsence(dateAbsence);
        absence.setHeureDebut(heuredubet);
        absence.setHeureFin(heurefin);
        absence.setJustifiee(justifiee);
        absence.setMotif(motif);

        Etudiant etudiant = etudiantService.findById(etudiantId);
        if (etudiant != null) {
            absence.setEtudiant(etudiant);
        }

        absenceService.save(absence);
        return "redirect:/absences/etudiant/" + etudiantId;
    }

    // Suppression
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        Absence absence = absenceService.findById(id);
        Long etudiantId = 1L;
        if (absence != null && absence.getEtudiant() != null) {
            etudiantId = absence.getEtudiant().getId();
        }
        absenceService.deleteById(id);
        return "redirect:/absences/etudiant/" + etudiantId;
    }
}