package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Operation;

import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.Compte;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
@DiscriminatorValue("O")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double montant;
    private String motif;
    private LocalDateTime date;

    @ManyToOne
    private Compte compte;

    public Operation() {}

    public Operation(double montant, String motif, LocalDateTime date, Compte compte) {
        this.montant = montant;
        this.motif = motif;
        this.date = date;
        this.compte = compte;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}
