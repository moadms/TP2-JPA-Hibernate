package ma.enset.tp2;

import ma.enset.tp2.model.CompteUtilisateur;
import ma.enset.tp2.model.SalleFormation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("===================================================================");
        System.out.println(">>> DEMARRAGE TP2 - GESTION ENTITES SALLE ET UTILISATEUR (JPA) <<<");
        System.out.println("===================================================================");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp2_salle_utilisateur");
        EntityManager em = emf.createEntityManager();

        try {
            // [1] CREATE
            System.out.println("\n--- [1] INSERTION (CREATE) ---");
            em.getTransaction().begin();

            CompteUtilisateur admin = new CompteUtilisateur("admin_moad", "Moad Moussaoui", "moussaoui9881@gmail.com", "hash_secret_pass");
            em.persist(admin);

            SalleFormation s1 = new SalleFormation("C101", "Lab Informatique Reseaux", 30, true);
            s1.setResponsableSalle(admin);

            SalleFormation s2 = new SalleFormation("C102", "Salle Multimédia", 45, true);
            s2.setResponsableSalle(admin);

            em.persist(s1);
            em.persist(s2);

            em.getTransaction().commit();
            System.out.println("✓ Utilisateur et Salles insérés avec succès.");

            // [2] READ
            System.out.println("\n--- [2] LECTURE (READ VIA JPQL) ---");
            List<SalleFormation> salles = em.createQuery("SELECT s FROM SalleFormation s WHERE s.avecProjecteur = true", SalleFormation.class).getResultList();
            for (SalleFormation sf : salles) {
                System.out.println(" -> Salle : " + sf.getIntitule() + " (Capacité: " + sf.getCapaciteMax() + ", N°: " + sf.getNumero() + ")");
            }

            // [3] UPDATE
            System.out.println("\n--- [3] MISE A JOUR (UPDATE) ---");
            em.getTransaction().begin();
            SalleFormation salleToUpdate = em.find(SalleFormation.class, s1.getId());
            if (salleToUpdate != null) {
                salleToUpdate.setCapaciteMax(35); // Augmentation de la capacité
                System.out.println("Capacité mise à jour pour " + salleToUpdate.getIntitule() + " : 35 places.");
            }
            em.getTransaction().commit();

            // [4] DELETE TEST
            System.out.println("\n--- [4] SUPPRESSION (DELETE) ---");
            em.getTransaction().begin();
            SalleFormation sTemp = new SalleFormation("TEMP-01", "Salle Temporaire", 10, false);
            em.persist(sTemp);
            em.flush();
            System.out.println("Salle temporaire créée avec ID : " + sTemp.getId());

            em.remove(sTemp);
            em.getTransaction().commit();
            System.out.println("✓ Salle temporaire supprimée avec succès.");

            System.out.println("\n===================================================================");
            System.out.println(">>> EXECUTION DU TP2 TERMINEE AVEC SUCCES <<<");
            System.out.println("===================================================================");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
