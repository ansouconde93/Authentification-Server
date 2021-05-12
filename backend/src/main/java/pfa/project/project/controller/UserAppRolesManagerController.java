package pfa.project.project.controller;

import pfa.project.project.entities.*;
import pfa.project.project.model.UserClientID;

import java.util.Collection;
import java.util.List;

public interface UserAppRolesManagerController {
    //Those functions are used for authentication and authorization process
    public Utilisateur getUserByUsername(String username);

    public Collection<Authorities> getUserAuthoritiesForApplication(UserClientID userClientID);

    public Utilisateur saveUtilisateur(Utilisateur utilisateur);

    public Roles saveRoles(Roles role);

    public Application saveApplication(Application application);

    public Authorities saveAuthorities(Authorities authority);

    public List<Application> getAllApplications();

    public List<Utilisateur> getAllUtilisateur();

    public List<Roles> getAllRoles();

    public List<Authorities> getAllAuthories();
}
