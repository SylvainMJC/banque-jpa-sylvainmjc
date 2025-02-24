package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte;

import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.Compte;
import jakarta.persistence.*;

@Entity
public class LivretA extends Compte {
    private double taux;

    public LivretA() {}

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
