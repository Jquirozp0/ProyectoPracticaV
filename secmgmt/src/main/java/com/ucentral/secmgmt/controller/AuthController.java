package com.ucentral.secmgmt.controller;

import com.ucentral.secmgmt.Security.JwtGenerador;
import com.ucentral.secmgmt.dtos.DtoAuthRespuesta;
import com.ucentral.secmgmt.dtos.DtoLogin;
import com.ucentral.secmgmt.dtos.DtoRegistro;
import com.ucentral.secmgmt.model.Role;
import com.ucentral.secmgmt.model.User;
import com.ucentral.secmgmt.repository.RoleRepository;
import com.ucentral.secmgmt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private JwtGenerador jwtGenerador;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
            RoleRepository roleRepository, UserRepository userRepository, JwtGenerador jwtGenerador) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.jwtGenerador = jwtGenerador;
    }


   @PostMapping("/register")
   public ResponseEntity<String> registrar(@RequestBody DtoRegistro dtoRegistro)
    {

        // Verificar si el usuario ya existe
        if (userRepository.existsByUsername(dtoRegistro.getUsername())) {
            return new ResponseEntity<>("El usuario ya existe", HttpStatus.BAD_REQUEST);
        }

        // Crear un nuevo usuario y asignar los valores del DTO
        User user = new User();
        user.setUsername(dtoRegistro.getUsername());
        user.setPassword(passwordEncoder.encode(dtoRegistro.getPassword()));
        user.setNombre(dtoRegistro.getNombre());
        user.setApellido(dtoRegistro.getApellido());
        user.setEmail(dtoRegistro.getEmail());
        user.setEstado(dtoRegistro.isEstado()); // Suponiendo que estado es un booleano

        // Obtener el rol seleccionado
        /*Optional<Role> selectedRole = roleRepository.findById(dtoRegistro.getRoleId());
        if (selectedRole.isEmpty()) {
            return new ResponseEntity<>("Rol no encontrado", HttpStatus.BAD_REQUEST);
        }
        user.setRoles(Collections.singletonList(selectedRole.get()));*/

        // Guardar el usuario en la base de datos
        userRepository.save(user);

        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<DtoAuthRespuesta> login(@RequestBody DtoLogin dtoLogin) {
        Optional<User> getUser = userRepository.findByUsername(dtoLogin.getUsername());
        Set<Long> getRole = userRepository.findRoleIdsByUserId(getUser.get().getId());
        Long firstRoleId = null;
        if (!getRole.isEmpty()) {
            firstRoleId = getRole.iterator().next();
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dtoLogin.getUsername(), dtoLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerador.generarToken(authentication);
        return new ResponseEntity<>(new DtoAuthRespuesta(token, firstRoleId), HttpStatus.OK);
    }

}
