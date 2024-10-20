package com.ucentral.secmgmt.Security;


import com.ucentral.secmgmt.model.Role;
import com.ucentral.secmgmt.model.User;
import com.ucentral.secmgmt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUsersDetailsService implements UserDetailsService {
    private UserRepository userRepository;
    @Autowired
    public CustomUsersDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Collection<GrantedAuthority> mapToAuthorities(List<Role> roles)
    {
        return  roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapToAuthorities(user.getRoles()));
    }
}
