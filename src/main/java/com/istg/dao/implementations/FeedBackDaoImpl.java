package com.istg.dao.implementations;

import com.istg.dao.Interface.FeedBackDao;
import com.istg.dao.Mappers.FeedBackMapper;
import com.istg.domain.FeedBack;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

public class FeedBackDaoImpl implements FeedBackDao {

    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(String.valueOf(FeedBackDaoImpl.class));

    public FeedBackDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(FeedBack feedBack) {
        String sql = "INSERT INTO feedback(id_tbgame,name_client,soname_client,email_client,mark)values(?,?,?,?,?)";
        log.info("Add feed back about table game"+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,feedBack.getId_tb_game(),feedBack.getName_client(),
                feedBack.getSoname_client(),feedBack.getEmail_client(),feedBack.getMark());
    }

    @Override
    public List<FeedBack> getAll() {
        String sql = "SELECT * FROM feedback";
        log.info("Get all feed back"+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.query(sql,new FeedBackMapper());
    }

    @Override
    public int update(FeedBack feedBack) {
        String sql = "UPDATE feedback SET name_client=?,soname_client=?,email_client=?,mark=? WHERE id_fd = ?";
        log.info("Update feed back by id - " + feedBack.getId_feedback()+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,feedBack.getName_client(),feedBack.getSoname_client(),
                feedBack.getEmail_client(),feedBack.getMark(),feedBack.getMark());
    }

    @Override
    public int delete(FeedBack feedBack) {
        String sql = "DELETE FROM feedback WHERE id_fd = ?";
        log.info("Delete feedback by id - " + feedBack.getId_feedback()+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,feedBack.getId_feedback());
    }

    @Override
    public FeedBack getById(Long id) {
        String sql = "SELECT * FROM feedback WHERE id_fd = ?";
        log.info("Get one feedback by id - " + id+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.queryForObject(sql,new FeedBackMapper(),id);
    }
}
