/*


package com.mng.todo.security;

import com.mng.todo.model.User;
import com.mng.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserDetails implements UserDetailsService {


    @Autowired
    private UserService userService;

    private org.springframework.security.core.userdetails.User springUser;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        User user = getUserDetail(username);
        if (user != null) {
            springUser = new org.springframework.security.core.userdetails.User(user.getUserName(),
                    user.getPassword(),
                    enabled,
                    accountNonExpired,
                    credentialsNonExpired,
                    accountNonLocked,
                    getAuthorities(user.getRole())
            );
            return springUser;
        } else {
            springUser = new org.springframework.security.core.userdetails.User("empty",
                    "empty",
                    false,
                    true,
                    true,
                    false,
                    getAuthorities(1)
            );
            return springUser;
        }
    }

    public List<GrantedAuthority> getAuthorities(Integer role) {

        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        if (role == 1) {
            authList.add(new SimpleGrantedAuthority("USER"));
        }
        if (role == 2) {
            authList.add(new SimpleGrantedAuthority("ADMIN"));
        }



        return authList;
    }

    private User getUserDetail(String username) {
        User user = userService.getUser(username);
        return user;
    }

}


*/
