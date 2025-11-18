package ma.fstt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Etudiant")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etu")
    private Long id;

    @Column
    private String nom;
    @Column
    private String prenom;
    @Column
    private LocalDate dateNaissance;
    @Column
    private String sexe;
    @Column
    private String NomParent;
    @Column
    private  String TelParent;
    @Column
    private  String photo;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    private List<Absence> absences;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;


}
