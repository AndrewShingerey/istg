package com.istg.service.implementations;

import com.istg.dao.Interface.UserDao;
import com.istg.domain.User;
import com.istg.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserDao userDao;

    private static final Logger log = Logger.getLogger(String.valueOf(UserServiceImpl.class));

    @Override
    public int save(User user) {
        if(userDao.getUserByUsername(user.getUsername())==null) {
            log.info("Save user by id - " + user.getId_user());
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            return userDao.save(user);
        }else{
            log.info("Not save user because user exists");
            return 0;
        }
    }

    @Override
    public List<User> getAll() {
        log.info("Get all user");
        return userDao.getAll();
    }

    @Override
    public int update(User user) {
        if(user.getId_user()!=null) {
            log.info("Update user");
            return userDao.update(user);
        }else{
            return 0;
        }
    }

    @Override
    public int delete(User user) {
        if(user.getId_user()!=null) {
            log.info("Delete user");
            return userDao.delete(user);
        }else{
            return 0;
        }
    }

    @Override
    public User getById(Long id) {
        if(id!=null) {
            log.info("Get user by id - " + id);
            return userDao.getById(id);
        }else{
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        final Optional<User> optionalUser = Optional.ofNullable(userDao.getUserByUsername(s));
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found.", s));
        }

    }
}
