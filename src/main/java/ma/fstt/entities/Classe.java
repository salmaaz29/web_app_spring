package ma.fstt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Classe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classe")
    private Long id;

    @Column
    private String libelle;
    @Column
    private  String niveau;
    @Column
    private String anneeScolaire;

    @OneToMany(mappedBy = "classe", cascade  = CascadeType.ALL , orphanRemoval = true)
   private List<Etudiant> etudiants = new ArrayList<>();

}
