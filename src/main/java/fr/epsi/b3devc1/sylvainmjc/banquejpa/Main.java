package fr.epsi.b3devc1.sylvainmjc.banquejpa;


import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Adresse;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Banque;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Client;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.AssuranceVie;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.Compte;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.Courant;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Compte.LivretA;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Operation.Operation;
import fr.epsi.b3devc1.sylvainmjc.banquejpa.bo.Operation.Virement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        try(
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
                EntityManager em = emf.createEntityManager();
        ) {
            EntityTransaction transaction = em.getTransaction();

            try {
                transaction.begin();


                System.out.println("Création de trois adresses...");
                Adresse adresse1 = new Adresse();
                adresse1.setNumero("1");
                adresse1.setRue("Rue de la Paix");
                adresse1.setCodePostal("75001");
                adresse1.setVille("Paris");

                Adresse adresse2 = new Adresse();
                adresse2.setNumero("2");
                adresse2.setRue("Rue de la Liberté");
                adresse2.setCodePostal("69001");
                adresse2.setVille("Lyon");

                Adresse adresse3 = new Adresse();
                adresse3.setNumero("3");
                adresse3.setRue("Rue de la République");
                adresse3.setCodePostal("13001");
                adresse3.setVille("Marseille");

                em.persist(adresse1);
                em.persist(adresse2);
                em.persist(adresse3);

                System.out.println("Création d’une banque...");
                Banque banque = new Banque();
                banque.setNom("Banque Populaire");
                em.persist(banque);

                System.out.println("Création de deux clients...");
                Client client1 = new Client();
                client1.setMontant(5000);
                client1.setMotif("Salaire");
                client1.setDate(LocalDateTime.now());
                client1.setAdresse(adresse1);
                client1.setBanque(banque);

                Client client2 = new Client();
                client2.setMontant(7000);
                client2.setMotif("Investissement");
                client2.setDate(LocalDateTime.now());
                client2.setAdresse(adresse2);
                client2.setBanque(banque);

                em.persist(client1);
                em.persist(client2);

                System.out.println("Création d’un compte associé aux 2 clients...");
                Courant compte1 = new Courant();
                compte1.setNumero("C12345");
                compte1.setSolde(10000);
                compte1.setDecouvert(500);
                compte1.setClient(client1);
                em.persist(compte1);

                compte1.setClient(client2);
                em.persist(compte1);

                System.out.println("Création d’un client avec plusieurs comptes...");
                Client client3 = new Client();
                client3.setMontant(15000);
                client3.setMotif("Epargne");
                client3.setDate(LocalDateTime.now());
                client3.setAdresse(adresse3);
                client3.setBanque(banque);
                em.persist(client3);

                AssuranceVie assuranceVie = new AssuranceVie();
                assuranceVie.setNumero("A67890");
                assuranceVie.setSolde(20000);
                assuranceVie.setDateFin(LocalDate.of(2030, 12, 31));
                assuranceVie.setTaux(2.5);
                assuranceVie.setClient(client3);

                LivretA livretA = new LivretA();
                livretA.setNumero("L56789");
                livretA.setSolde(5000);
                livretA.setTaux(1.2);
                livretA.setClient(client3);

                em.persist(assuranceVie);
                em.persist(livretA);

                System.out.println("Ajout des opérations de type Virement sur un compte...");
                Virement virement1 = new Virement();
                virement1.setMontant(200);
                virement1.setMotif("Loyer");
                virement1.setDate(LocalDateTime.now());
                virement1.setCompte(compte1);
                virement1.setBeneficiaire("Propriétaire");

                Virement virement2 = new Virement();
                virement2.setMontant(500);
                virement2.setMotif("Transfert ami");
                virement2.setDate(LocalDateTime.now());
                virement2.setCompte(compte1);
                virement2.setBeneficiaire("Ami");

                em.persist(virement1);
                em.persist(virement2);

                System.out.println("Ajout des opérations de type générique sur un compte...");
                Operation operation1 = new Operation();
                operation1.setMontant(100);
                operation1.setMotif("Achat supermarché");
                operation1.setDate(LocalDateTime.now());
                operation1.setCompte(livretA);

                Operation operation2 = new Operation();
                operation2.setMontant(150);
                operation2.setMotif("Achat restaurant");
                operation2.setDate(LocalDateTime.now());
                operation2.setCompte(livretA);

                em.persist(operation1);
                em.persist(operation2);

                transaction.commit();
                System.out.println("Données insérées avec succès !");
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            } finally {
                em.close();
                emf.close();
            }
        }
    }

}
