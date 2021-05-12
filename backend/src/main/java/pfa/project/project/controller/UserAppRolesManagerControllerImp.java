package pfa.project.project.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pfa.project.project.config.PathUrlConfig;
import pfa.project.project.entities.*;
import pfa.project.project.model.UserClientID;
import pfa.project.project.service.UserAppRolesManagerService;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin("*")
@Api(description="Constroler of authentication and authorization")

public class UserAppRolesManagerControllerImp implements UserAppRolesManagerController{
    @Autowired
    private UserAppRolesManagerService userAppRolesManagerService;

    /*
            Functions are used to control authentication and authorization process
     */
    @ApiOperation(value = "This fuction can get user by his name.")
    @PostMapping(PathUrlConfig.USERDATAACCESPATH+"/userbyname")
    @Override
    public Utilisateur getUserByUsername(@RequestBody String username) {
        return userAppRolesManagerService.getUserByUsername(username);
    }

    @PostMapping(PathUrlConfig.USERDATAACCESPATH+"/clientid")
    @Override
    @ApiOperation(value = "This fuction can all get roles about given user and clientID.")
    public Collection<Authorities> getUserAuthoritiesForApplication(@RequestBody UserClientID userClientID) {
        return userAppRolesManagerService.getUserAuthoritiesForApplication(
                userClientID.getUsername(),userClientID.getClientID());
    }

    @PostMapping(PathUrlConfig.USERDATAACCESPATH+"/saveuser")
    @Override
    @ApiOperation(value = "Method to save a given user")
    public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
        return userAppRolesManagerService.saveUtilisateur(utilisateur);
    }

    @PostMapping(PathUrlConfig.ROLEACCESPATH+"/saverole")
    @Override
    @ApiOperation(value = "Method to save a given role")
    public Roles saveRoles(@RequestBody Roles role) {
        return userAppRolesManagerService.saveRoles(role);
    }

    @PostMapping(PathUrlConfig.APPACCESPATH+"/saveapp")
    @Override
    @ApiOperation(value = "Method to save a given userApp")
    public Application saveApplication(@RequestBody Application userApp) {
        return userAppRolesManagerService.saveApplication(userApp);
    }

    @PostMapping(PathUrlConfig.AUTHORITIESACCESPATH+"/saveauth")
    @Override
    @ApiOperation(value = "Method to save a given authority")
    public Authorities saveAuthorities(@RequestBody Authorities authories) {
        return userAppRolesManagerService.saveAuthorities(authories);
    }

    @GetMapping(PathUrlConfig.APPACCESPATH+"/apps")
    @Override
    @ApiOperation(value = "Method to get all userApp ")
    public List<Application> getAllApplications() {
        return userAppRolesManagerService.getAllApplications();
    }

    @GetMapping(PathUrlConfig.USERDATAACCESPATH+"/users")
    @Override
    @ApiOperation(value = "Method to get all user ")
    public List<Utilisateur> getAllUtilisateur() {
        return userAppRolesManagerService.getAllUtilisateur();
    }

    @GetMapping(PathUrlConfig.ROLEACCESPATH+"/roles")
    @Override
    @ApiOperation(value = "Method to get all roles ")
    public List<Roles> getAllRoles() {
        return userAppRolesManagerService.getAllRoles();
    }

    @GetMapping(PathUrlConfig.AUTHORITIESACCESPATH+"/authorities")
    @Override
    @ApiOperation(value = "Method to get all authorities ")
    public List<Authorities> getAllAuthories() {
        return userAppRolesManagerService.getAllAuthories();
    }

}
