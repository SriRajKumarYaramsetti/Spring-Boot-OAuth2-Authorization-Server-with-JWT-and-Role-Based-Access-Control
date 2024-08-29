package com.SriRaj.AutherzationServer.Security;

import com.SriRaj.AutherzationServer.Models.User;
import com.SriRaj.AutherzationServer.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class CustomSpringUserDetailsService implements UserDetailsService {
   private UserRepository userRepository;




   @Autowired
   public CustomSpringUserDetailsService(UserRepository userRepository){
       this.userRepository=userRepository;

   }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userOptional=userRepository.findByEmail(username);

        if (userOptional.isEmpty()){
            throw new UsernameNotFoundException("User Not Found");
        }

       User user=userOptional.get();
       return new CustomSpringUserDetails(user);
    }
}
