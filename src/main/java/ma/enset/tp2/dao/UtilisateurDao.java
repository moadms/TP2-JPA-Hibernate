package ma.enset.tp2.dao;

import ma.enset.tp2.model.CompteUtilisateur;
import javax.persistence.EntityManagerFactory;

public class UtilisateurDao extends AbstractGenericDao<CompteUtilisateur, Long> {
    public UtilisateurDao(EntityManagerFactory emf) {
        super(emf, CompteUtilisateur.class);
    }
}
