package pfa.project.project.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import pfa.project.project.entities.Application;

public interface ApplicationRepository extends JpaRepository<Application,Long> {
    public Application findByClientid(String clientID);
}
