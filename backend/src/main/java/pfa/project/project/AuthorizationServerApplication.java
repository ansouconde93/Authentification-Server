package pfa.project.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pfa.project.project.controller.UserAppRolesManagerControllerImp;
import pfa.project.project.entities.*;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootApplication
public class AuthorizationServerApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AuthorizationServerApplication.class, args);
        UserAppRolesManagerControllerImp userAppRolesManagerController = context.getBean(UserAppRolesManagerControllerImp.class);

        Utilisateur u1 = new Utilisateur();
        u1.setUsername("if1");
        u1.setPassword("if1");
        u1 = userAppRolesManagerController.saveUtilisateur(u1);

        Utilisateur u2 = new Utilisateur();
        u2.setUsername("if2");
        u2.setPassword("if2");
        u2 = userAppRolesManagerController.saveUtilisateur(u2);

        Utilisateur u3 = new Utilisateur();
        u3.setUsername("if3");
        u3.setPassword("if3");
        u3 = userAppRolesManagerController.saveUtilisateur(u3);

        Utilisateur u4 = new Utilisateur();
        u4.setUsername("if4");
        u4.setPassword("if4");
        u4 = userAppRolesManagerController.saveUtilisateur(u4);

        Utilisateur u5 = new Utilisateur();
        u5.setUsername("if5");
        u5.setPassword("if5");
        u5 = userAppRolesManagerController.saveUtilisateur(u5);



            Application a1 = userAppRolesManagerController.saveApplication(
                new Application(null,"if1app","if1app","if1app",null));
        Application a2 = userAppRolesManagerController.saveApplication(
                new Application(null,"if2app","if2app","if2app",null));
        Application a3 = userAppRolesManagerController.saveApplication(
                new Application(null,"if3app","if3app","if3app",null));
        Application a4 = userAppRolesManagerController.saveApplication(
                new Application(null,"if4app","if4app","if4app",null));
        Application a5 = userAppRolesManagerController.saveApplication(
                new Application(null,"if5app","if5app","if5app",null));

        Roles r1= userAppRolesManagerController.saveRoles(
                new Roles(null,"user",u1,a2,null));
        Roles r2=  userAppRolesManagerController.saveRoles(
                new Roles(null,"chefDepartement",u2,a1,null));
        Roles r3=  userAppRolesManagerController.saveRoles(
                new Roles(null,"admin",u5,a5,null));
        Roles r4=  userAppRolesManagerController.saveRoles(
                new Roles(null,"manager",u1,a3,null));
        Roles r5=  userAppRolesManagerController.saveRoles(
                new Roles(null,"auditor",u2,a3,null));

        Authorities au1 = new Authorities();
        au1.setAuthorityname("create");
        Authorities au2 = new Authorities();
        au2.setAuthorityname("read");
        Authorities au3 = new Authorities();
        au3.setAuthorityname("update");
        Authorities au4 = new Authorities();
        au4.setAuthorityname("delete");
        Authorities au5 = new Authorities();
        au5.setAuthorityname("view");
        Collection<Roles> role = new ArrayList<>();
        role.add(r2);
        role.add(r3);
        role.add(r4);
        au1.setRoles(role);

        role = new ArrayList<>();
        au3.setRoles(au1.getRoles());
        au4.setRoles(au1.getRoles());

        role.add(r1);
        role.add(r2);
        role.add(r4);
        role.add(r5);
        au2.setRoles(role);
        au5.setRoles(au2.getRoles());
        au1=userAppRolesManagerController.saveAuthorities(au1);
        au2=userAppRolesManagerController.saveAuthorities(au2);
        au3=userAppRolesManagerController.saveAuthorities(au3);
        au4=userAppRolesManagerController.saveAuthorities(au4);
        au5=userAppRolesManagerController.saveAuthorities(au5);
    }

}
