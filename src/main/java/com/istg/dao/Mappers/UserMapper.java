package com.istg.dao.Mappers;

import com.istg.domain.User;
import com.istg.domain.enums.UserRole;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId_user(resultSet.getLong("id_user"));
        user.setUsername(resultSet.getString("username"));
        user.setName(resultSet.getString("name_user"));
        user.setSoname(resultSet.getString("soname_user"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password_user"));
        user.setRole(UserRole.valueOf(resultSet.getString("role_user")));
        return user;
    }
}
