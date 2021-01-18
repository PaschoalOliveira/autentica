package io.com.salus.autentica.service;
import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import io.com.salus.autentica.model.Usuario;
import io.com.salus.autentica.repository.UsuarioRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private UsuarioRepository userRepository;
    
    public UserDetailsServiceImpl(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByUsername(username);
        
        if(user == null) {
            throw new UsernameNotFoundException(username); 
        }
        
        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }
}
