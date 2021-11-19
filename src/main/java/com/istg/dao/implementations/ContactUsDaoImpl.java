package com.istg.dao.implementations;

import com.istg.dao.Interface.ContactUsDao;
import com.istg.dao.Mappers.ContactUsMapper;
import com.istg.domain.ContactUs;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

public class ContactUsDaoImpl implements ContactUsDao {

    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(String.valueOf(ContactUsDaoImpl.class));


    public ContactUsDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(ContactUs contactUs) {
        String sql = "INSERT INTO ContactUs(name_ct,soname_ct,email_ct,phone_ct,date_send)values(?,?,?,?,?)";
        log.info("Save request contact us" +" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,contactUs.getName_ct(),contactUs.getSoname_ct(),contactUs.getEmail_ct(),contactUs.getPhone_ct(),contactUs.getDate_add());
    }

    @Override
    public List<ContactUs> getAll() {
        String sql = "SELECT * FROM ContactUs";
        log.info("Get all contacts us request "+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.query(sql,new ContactUsMapper());
    }

    @Override
    public int update(ContactUs contactUs) {
        String sql = "UPDATE ContactUs SET name_ct=?,soname_ct=?,email_ct=?,phone_ct=?,date_send=? WHERE id_ct=?";
        log.info("Update contact us request "+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,contactUs.getName_ct(),contactUs.getSoname_ct(),contactUs.getEmail_ct(),contactUs.getPhone_ct(),contactUs.getDate_add(),contactUs.getId_ct());
    }

    @Override
    public int delete(ContactUs contactUs) {
        String sql = "DELETE FROM ContactUs WHERE id_ct = ?";
        log.info("Delete contact us request by id - " +contactUs.getId_ct() +" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,contactUs.getId_ct());
    }

    @Override
    public ContactUs getById(Long id) {
        String sql = "SELECT * FROM ContactUs WHERE id_ct = ?";
        log.info("Get contact us request by id - " + id +" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.queryForObject(sql,new ContactUsMapper(),id);
    }
}
