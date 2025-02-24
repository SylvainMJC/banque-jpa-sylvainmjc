package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo;

import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.Compte;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    @OneToMany(mappedBy = "banque")
    private List<Client> clients;


    public Banque() {}

    public Banque(String nom, List<Client> clients) {
        this.nom = nom;
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
