package ma.enset.tp2.dao;

import ma.enset.tp2.model.SalleFormation;
import javax.persistence.EntityManagerFactory;

public class SalleDao extends AbstractGenericDao<SalleFormation, Long> {
    public SalleDao(EntityManagerFactory emf) {
        super(emf, SalleFormation.class);
    }
}
