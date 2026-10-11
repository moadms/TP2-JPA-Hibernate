package ma.enset.tp2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_comptes_utilisateurs")
public class CompteUtilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long id;

    @Column(name = "pseudo_connexion", unique = true, nullable = false, length = 50)
    private String login;

    @Column(name = "nom_complet", nullable = false, length = 120)
    private String nom;

    @Column(name = "adresse_electronique", unique = true, nullable = false, length = 150)
    private String email;

    @Column(name = "mot_de_passe_hash", nullable = false)
    private String motDePasse;

    @OneToMany(mappedBy = "responsableSalle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SalleFormation> sallesSupervisees = new ArrayList<>();

    public CompteUtilisateur() {
    }

    public CompteUtilisateur(String login, String nom, String email, String motDePasse) {
        this.login = login;
        this.nom = nom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<SalleFormation> getSallesSupervisees() {
        return sallesSupervisees;
    }

    public void setSallesSupervisees(List<SalleFormation> sallesSupervisees) {
        this.sallesSupervisees = sallesSupervisees;
    }

    @Override
    public String toString() {
        return "CompteUtilisateur{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
