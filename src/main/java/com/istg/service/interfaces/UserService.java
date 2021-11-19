package com.istg.service.interfaces;

import com.istg.dao.Interface.BaseDaoCRUD;
import com.istg.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    int save(User user);
    List<User> getAll();
    int update(User t);
    int delete(User t);
    User getById(Long id);
}
