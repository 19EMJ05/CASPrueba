package com.aplicacion.WebAplicacion.servicios;

import com.aplicacion.WebAplicacion.dao.UsuariosDao;
import com.aplicacion.WebAplicacion.modelo.Usuarios;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService implements UserDetailsService{
    
    private String rol;
    private String idus;
    @Autowired
    private UsuariosDao usuariosDao;
    @Override
    public UserDetails loadUserByUsername(String iduser) throws UsernameNotFoundException {
        Usuarios user= usuariosDao.findById(iduser).orElse(null);
        
        if (user !=null ){
            idus=iduser;
            var spUser = User.withUsername(user.getContraseña())
                    .password("{noop}"+user.getContraseña())
                    .roles(user.getIdrol())
                    .build();
            role(user.getIdrol());
            return spUser;
        }
        return null;  
    }   
    private void role(String roles){
        rol=roles;
    }
    public String getrole(){
        return rol;
    }
        public String getUser(){
        return idus;
    }
}
