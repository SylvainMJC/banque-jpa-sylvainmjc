package fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte;

import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Banque;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Client;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Operation.Operation;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numero;
    private double solde;

    @ManyToOne
    private Client client;


    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;

    public Compte() {}

    public Compte(String numero, double solde, Client client, List<Operation> operations) {
        this.numero = numero;
        this.solde = solde;
        this.client = client;
        this.operations = operations;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
}
