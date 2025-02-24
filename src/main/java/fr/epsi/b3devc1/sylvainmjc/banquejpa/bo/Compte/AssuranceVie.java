package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte;

import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.Compte;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte {
    private LocalDate dateFin;
    private double taux;

    public AssuranceVie() {}

    public AssuranceVie(LocalDate dateFin, double taux) {
        this.dateFin = dateFin;
        this.taux = taux;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    // Getters et Setters
}
