package ma.enset.tp2.service;

import ma.enset.tp2.dao.SalleDao;
import ma.enset.tp2.dao.UtilisateurDao;
import ma.enset.tp2.model.CompteUtilisateur;
import ma.enset.tp2.model.SalleFormation;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ServiceGestion {
    private final SalleDao salleDao;
    private final UtilisateurDao utilisateurDao;

    public ServiceGestion(EntityManagerFactory emf) {
        this.salleDao = new SalleDao(emf);
        this.utilisateurDao = new UtilisateurDao(emf);
    }

    public void enregistrerSalle(SalleFormation s) {
        salleDao.save(s);
    }

    public void modifierSalle(SalleFormation s) {
        salleDao.update(s);
    }

    public void supprimerSalle(SalleFormation s) {
        salleDao.delete(s);
    }

    public SalleFormation trouverSalleParId(Long id) {
        return salleDao.findById(id);
    }

    public List<SalleFormation> listerToutesLesSalles() {
        return salleDao.findAll();
    }

    public void enregistrerUtilisateur(CompteUtilisateur u) {
        utilisateurDao.save(u);
    }

    public void modifierUtilisateur(CompteUtilisateur u) {
        utilisateurDao.update(u);
    }

    public void supprimerUtilisateur(CompteUtilisateur u) {
        utilisateurDao.delete(u);
    }

    public CompteUtilisateur trouverUtilisateurParId(Long id) {
        return utilisateurDao.findById(id);
    }

    public List<CompteUtilisateur> listerTousLesUtilisateurs() {
        return utilisateurDao.findAll();
    }
}
