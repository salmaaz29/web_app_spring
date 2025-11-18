package ma.fstt.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name= "Absence")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_abs")
    private Long id ;

    @Column
    private LocalDate dateAbsence;
    @Column
    private LocalTime heureDebut;
    @Column
    private LocalTime heureFin;
    @Column
    private Boolean justifiee = false;
    @Column
    private String motif;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

}
