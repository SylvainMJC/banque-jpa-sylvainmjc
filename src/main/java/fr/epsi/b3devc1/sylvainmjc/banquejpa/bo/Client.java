package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo;

import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.Compte;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double montant;
    private String motif;
    private LocalDateTime date;

    @OneToOne
    private Adresse adresse;

    @OneToMany(mappedBy = "client")
    private List<Compte> comptes;

    @ManyToOne
    private Banque banque;

    public Client() {}

    public Client(double montant, String motif, LocalDateTime date, Adresse adresse, List<Compte> comptes, Banque banque) {
        this.montant = montant;
        this.motif = motif;
        this.date = date;
        this.adresse = adresse;
        this.comptes = comptes;
        this.banque = banque;
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

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }
}
