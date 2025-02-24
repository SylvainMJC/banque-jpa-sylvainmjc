package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Operation;

import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Operation.Operation;
import jakarta.persistence.*;


@Entity
public class Virement extends Operation {
    private String beneficiaire;

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
