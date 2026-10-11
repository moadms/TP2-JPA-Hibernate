# TP 2 : Gestion des Entités Salle et Utilisateur avec JPA et Hibernate

Projet de manipulation des entités fondamentales `CompteUtilisateur` et `SalleFormation` avec **JPA 2.2** et **Hibernate ORM 5.6** sur base **H2 Database**.

---

## 1. Description du Modèle

- **`CompteUtilisateur` (`t_comptes_utilisateurs`)** :
  - `id`, `login` (unique), `nom`, `email` (unique), `motDePasse`.
  - Relation `@OneToMany(mappedBy = "responsableSalle")` vers `SalleFormation`.
- **`SalleFormation` (`t_salles_formation`)** :
  - `id`, `numero` (unique), `intitule`, `capaciteMax`, `avecProjecteur`.
  - Relation `@ManyToOne` vers `CompteUtilisateur`.

---

## 2. Opérations CRUD Implémentées

1. **Create** : Persistance d'un compte utilisateur superviseur et de plusieurs salles.
2. **Read** : Requête JPQL `SELECT s FROM SalleFormation s WHERE s.avecProjecteur = true`.
3. **Update** : Modification de la capacité d'une salle existante.
4. **Delete** : Création puis suppression d'une entité temporaire via `em.remove()`.

---

## 3. Démarrage du Projet

```bash
mvn clean compile exec:java "-Dexec.mainClass=ma.enset.tp2.App"
```
