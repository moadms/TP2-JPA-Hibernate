package ma.enset.tp2.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_salles_formation")
public class SalleFormation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salle")
    private Long id;

    @Column(name = "numero_salle", unique = true, nullable = false, length = 20)
    private String numero;

    @Column(name = "nom_salle", nullable = false, length = 80)
    private String intitule;

    @Column(name = "capacite_etudiants")
    private Integer capaciteMax;

    @Column(name = "est_equipee_projecteur")
    private Boolean avecProjecteur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_responsable_id")
    private CompteUtilisateur responsableSalle;

    public SalleFormation() {
    }

    public SalleFormation(String numero, String intitule, Integer capaciteMax, Boolean avecProjecteur) {
        this.numero = numero;
        this.intitule = intitule;
        this.capaciteMax = capaciteMax;
        this.avecProjecteur = avecProjecteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Integer getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(Integer capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

    public Boolean getAvecProjecteur() {
        return avecProjecteur;
    }

    public void setAvecProjecteur(Boolean avecProjecteur) {
        this.avecProjecteur = avecProjecteur;
    }

    public CompteUtilisateur getResponsableSalle() {
        return responsableSalle;
    }

    public void setResponsableSalle(CompteUtilisateur responsableSalle) {
        this.responsableSalle = responsableSalle;
    }

    @Override
    public String toString() {
        return "SalleFormation{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", intitule='" + intitule + '\'' +
                ", capaciteMax=" + capaciteMax +
                ", avecProjecteur=" + avecProjecteur +
                '}';
    }
}
