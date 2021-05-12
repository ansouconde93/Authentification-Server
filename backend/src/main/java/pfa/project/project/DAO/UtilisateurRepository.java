package pfa.project.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.project.project.entities.Utilisateur;
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
 public Utilisateur findByUsername(String username);
}
