package com.istg.dao.Interface;

import com.istg.domain.User;

public interface UserDao extends BaseDaoCRUD<User> {

        User getUserByUsername(String username);

}
