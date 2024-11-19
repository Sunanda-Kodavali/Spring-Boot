package com.example.f14_MysqlUser.services;

import com.example.f14_MysqlUser.models.UserAccount;
import com.example.f14_MysqlUser.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAccountRepository userAccountRepository;



    @Override
    public UserDetails loadUserByUsername(String username) {
        UserAccount userAccount = userAccountRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return User
                .withUsername(userAccount.getUsername())
                .password(userAccount.getPassword())
                .build();
    }

    public UserAccount createUserAccount(String username, String password) {
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername(username);
        userAccount.setPassword(passwordEncoder.encode(password));
        userAccount.setEnabled(true);
        return userAccountRepository.save(userAccount);
    }
}
