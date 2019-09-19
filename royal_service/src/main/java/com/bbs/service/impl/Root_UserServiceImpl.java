package com.bbs.service.impl;

import com.bbs.dao.User_ManageDao;
import com.bbs.service.Root_IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("root_UserService")
@Transactional
public class Root_UserServiceImpl implements Root_IUserService {

    @Autowired
    private User_ManageDao user_manageDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.bbs.domain.User rusers = null;

        try {
            rusers = user_manageDao.findByUsername(username);
          //  AuthenticationException attributes = (AuthenticationException) session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = new User(rusers.getUserName(),"{noop}"+rusers.getUserPass(),true,true,true,true,getAuthority(rusers.getRole()));


        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthority(Integer role) {
        String roleStr="USER";
        List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
        if(role==1){
            roleStr="USER";
        }
        if (role==2){
            roleStr="SUPERUSER";
        }
        if(role==3){
            roleStr="ADMIN";
        }
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+roleStr);
        list.add(authority);
        return list;
    }

}
