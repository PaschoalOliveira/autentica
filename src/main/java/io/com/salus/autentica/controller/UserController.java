package io.com.salus.autentica.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.com.salus.autentica.model.Usuario;
import io.com.salus.autentica.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

    private UsuarioRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UsuarioRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.userRepository = userRepository;

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    
    @PostMapping("/signup")
    public void signUp(@RequestBody Usuario user) {
    	
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

}