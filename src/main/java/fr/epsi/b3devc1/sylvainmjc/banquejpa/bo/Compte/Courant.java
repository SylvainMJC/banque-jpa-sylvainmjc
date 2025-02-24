package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte;

import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Client;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Operation.Operation;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Courant extends Compte {
    private double decouvert;

    public Courant() {}

    public Courant(String numero, double solde, Client client, List<Operation> operations, double decouvert) {
        super(numero, solde, client, operations);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
