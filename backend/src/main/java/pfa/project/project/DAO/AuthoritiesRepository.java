package pfa.project.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.project.project.entities.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities,Long> {
    public Authorities findByAuthorityname(String authority);
}
