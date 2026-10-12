package ma.enset.tp2;

import ma.enset.tp2.model.CompteUtilisateur;
import ma.enset.tp2.model.SalleFormation;
import ma.enset.tp2.service.ServiceGestion;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceGestionTest {
    private static EntityManagerFactory emf;
    private static ServiceGestion service;

    @BeforeAll
    public static void setUp() {
        emf = Persistence.createEntityManagerFactory("tp2_salle_utilisateur");
        service = new ServiceGestion(emf);
    }

    @AfterAll
    public static void tearDown() {
        if (emf != null && emf.isOpen()) emf.close();
    }

    @Test
    public void testCrudSalleFormation() {
        SalleFormation s = new SalleFormation("SALLE-101", "Salle Ada Lovelace", 35, true);
        service.enregistrerSalle(s);
        assertNotNull(s.getId());

        SalleFormation found = service.trouverSalleParId(s.getId());
        assertNotNull(found);
        assertEquals("Salle Ada Lovelace", found.getIntitule());

        found.setCapaciteMax(40);
        service.modifierSalle(found);
        SalleFormation updated = service.trouverSalleParId(s.getId());
        assertEquals(40, updated.getCapaciteMax());

        List<SalleFormation> salles = service.listerToutesLesSalles();
        assertFalse(salles.isEmpty());
    }

    @Test
    public void testCrudCompteUtilisateur() {
        CompteUtilisateur u = new CompteUtilisateur("moad_user", "Moussaoui Moad", "moad.pro@edu.ma", "hash_secret_pass");
        service.enregistrerUtilisateur(u);
        assertNotNull(u.getId());

        CompteUtilisateur found = service.trouverUtilisateurParId(u.getId());
        assertNotNull(found);
        assertEquals("Moussaoui Moad", found.getNom());
    }
}
