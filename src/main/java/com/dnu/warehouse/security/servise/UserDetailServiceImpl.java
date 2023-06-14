package com.dnu.warehouse.security.servise;

import com.dnu.warehouse.domain.dao.User;
import com.dnu.warehouse.domain.repository.UserRepository;
import com.dnu.warehouse.security.model.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("User does not exist"));
        return SecurityUser.fromUser(user);
    }
}
