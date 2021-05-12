package pfa.project.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.project.project.entities.Application;
import pfa.project.project.entities.Roles;
import pfa.project.project.entities.Utilisateur;

import java.util.List;

public interface RolesRepository extends JpaRepository<Roles,Long> {
    public Roles findByRolename(String roleName);
    public List<Roles> findByApplication(Application application);
    public List<Roles> findByUser(Utilisateur utilisateur);
}
