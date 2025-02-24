package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Operation;

import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.Compte;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Operation.Operation;
import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@DiscriminatorValue("V")
public class Virement extends Operation {
    private String beneficiaire;

    public Virement() {}

    public Virement(double montant, String motif, LocalDateTime date, Compte compte, String beneficiaire) {
        super(montant, motif, date, compte);
        this.beneficiaire = beneficiaire;
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
