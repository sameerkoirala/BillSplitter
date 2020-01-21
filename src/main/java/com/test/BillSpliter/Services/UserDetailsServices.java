package com.test.BillSpliter.Services;

import com.test.BillSpliter.beans.MyuserDetails;
import com.test.BillSpliter.beans.User;
import com.test.BillSpliter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServices implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.getUserByUserName( username);
        if (u == null)
        {
            throw new UsernameNotFoundException("Username "+ username + " not found");
        }

        return new MyuserDetails(u);
    }
}
