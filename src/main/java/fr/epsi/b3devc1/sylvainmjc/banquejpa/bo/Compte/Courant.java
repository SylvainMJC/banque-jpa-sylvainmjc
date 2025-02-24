package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte;

import jakarta.persistence.*;

@Entity
public class Courant extends Compte {
    private double decouvert;

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
