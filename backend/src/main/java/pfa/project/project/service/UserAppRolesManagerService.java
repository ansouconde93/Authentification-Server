package pfa.project.project.service;

import pfa.project.project.entities.*;

import java.util.Collection;
import java.util.List;

public interface UserAppRolesManagerService {
    //Those functions are used for authentication and authorization process
    public Utilisateur getUserByUsername(String username);
    public Collection<Authorities> getUserAuthoritiesForApplication(String username, String clientID);

    public Utilisateur saveUtilisateur(Utilisateur utilisateur);
    public Roles saveRoles(Roles role);
    public Application saveApplication(Application application);
    public Authorities saveAuthorities(Authorities authority);
    public List<Application> getAllApplications();
    public List<Utilisateur> getAllUtilisateur();
    public List<Roles> getAllRoles();
    public List<Authorities> getAllAuthories();
}
