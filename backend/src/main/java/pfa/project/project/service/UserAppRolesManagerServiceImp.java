package pfa.project.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pfa.project.project.DAO.*;
import pfa.project.project.entities.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@Transactional
public class UserAppRolesManagerServiceImp implements UserAppRolesManagerService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private RolesRepository rolesRepository;
    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    /*
            Functions for authentication and authorization process
     */

    @Override
    public Utilisateur getUserByUsername(String username) {
        return utilisateurRepository.findByUsername(username);
    }

    @Override
    public Collection<Authorities> getUserAuthoritiesForApplication(String username, String clientID) {
        Collection<Authorities> authories = new ArrayList<>();
        Utilisateur utilisateur = utilisateurRepository.findByUsername(username);
        utilisateur.getRoles().forEach(role -> {
            if(role.getApplication().getClientid().equals(clientID))
                authories.addAll(role.getAutorities());
        });
        return  authories;
    }

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Roles saveRoles(Roles roles) {
        return rolesRepository.save(roles);
    }

    @Override
    public Application saveApplication(Application userApp) {
        return applicationRepository.save(userApp);
    }

    @Override
    public Authorities saveAuthorities(Authorities authories) {
        return authoritiesRepository.save(authories);
    }

    @Override
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    @Override
    public List<Authorities> getAllAuthories() {
        return authoritiesRepository.findAll();
    }
}
