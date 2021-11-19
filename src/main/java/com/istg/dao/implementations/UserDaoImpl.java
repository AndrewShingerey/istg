package com.istg.dao.implementations;

import com.istg.dao.Interface.UserDao;
import com.istg.dao.Mappers.UserMapper;
import com.istg.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate jdbcTemplate;
    private static final Logger log = Logger.getLogger(String.valueOf(UserDaoImpl.class));

    public UserDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(User user) {
        String sql = "Insert into Usr(username,name_user,soname_user,email,password_user,role_user)values(?,?,?,?,?,?)";
        log.info("Save new user and create card for him"+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,user.getUsername(),user.getName(),user.getSoname(),user.getEmail(),user.getPassword(),user.getRole().toString());
    }

    @Override
    public List<User> getAll() {
        String sql ="SELECT * FROM usr";
        log.info("Get all user"+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.query(sql,new UserMapper());
    }

    @Override
    public int update(User user) {
        String sql ="UPDATE usr SET username = ?, name_user=?, soname_user=? ,email=?,role_user=? WHERE id_user=?";
        log.info("Update user by id - " + user.getId_user()+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,user.getUsername(),user.getName(),user.getSoname(),user.getEmail(),user.getRole().toString(),user.getId_user());
    }

    @Override
    public int delete(User user) {
        String sql ="DELETE FROM usr WHERE id_user=?";
        String sql_delete_card = "DELETE FROM card WHERE id_user=?";
        log.info("Delete user and card by id - " + user.getId_user()+" "+new Date(new java.util.Date().getTime()));
        jdbcTemplate.update(sql_delete_card,user.getId_user());
        return jdbcTemplate.update(sql,user.getId_user());
    }

    @Override
    public User getById(Long id) {
        String sql ="SELECT * FROM usr WHERE id_user = ?";
        log.info("Get user by id - " + id+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.queryForObject(sql,new UserMapper(),id);
    }

    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT * FROM Usr WHERE username = ?";
        log.info("Get user by username - " + username +" "+new Date(new java.util.Date().getTime()));
        try {
            return jdbcTemplate.queryForObject(sql, new UserMapper(), username);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

     }
}
