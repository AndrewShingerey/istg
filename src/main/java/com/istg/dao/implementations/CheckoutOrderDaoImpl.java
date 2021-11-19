package com.istg.dao.implementations;

import com.istg.dao.Interface.CheckoutOrderDao;
import com.istg.dao.Mappers.CheckoutOrderMapper;
import com.istg.domain.CheckoutOrder;
import com.istg.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

public class CheckoutOrderDaoImpl implements CheckoutOrderDao {

    private JdbcTemplate jdbcTemplate;

    private static final Logger log = Logger.getLogger(String.valueOf(CheckoutOrderDaoImpl.class));

    public CheckoutOrderDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(CheckoutOrder checkoutOrder, User user) {
        String sql = "INSERT INTO checkout_order(id_card_pr,name_client,soname_client,email_client,phone_client,summa_order,date_order) " +
                "values((select id_card from card where id_user = ?),?,?,?,?,( select sum(price) from card_product left join table_games on card_product.id_game = table_games.id_game where id_card = (select id_card from card where id_user = ?)),?)";
        log.info("Save new order" + " " + new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,user.getId_user(),checkoutOrder.getName_client(),
                checkoutOrder.getSoname_client(),checkoutOrder.getEmail_client(),checkoutOrder.getPhone_client(),user.getId_user(),checkoutOrder.getDate_order());
    }

    @Override
    public int save(CheckoutOrder checkoutOrder) {
        String sql = "INSERT INTO checkout_order(id_card_pr,name_client,soname_client,email_client,phone_client,summa_order,date_order) " +
                "values((select id_card from card where id_user = ?),?,?,?,?,( select sum(price) from card_product left join table_games on card_product.id_game = table_games.id_game where id_card = (select id_card from card where id_user = ?)),?)";
        log.info("Save new order" + " " + new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,checkoutOrder.getId_card_pr(),checkoutOrder.getName_client(),
                checkoutOrder.getSoname_client(),checkoutOrder.getEmail_client(),checkoutOrder.getPhone_client(),checkoutOrder.getId_card_pr(),checkoutOrder.getDate_order());
    }

    @Override
    public List<CheckoutOrder> getAll() {
        String sql = "SELECT * FROM checkout_order";
        log.info("Get all order" + " " + new Date(new java.util.Date().getTime()));
        return jdbcTemplate.query(sql,new CheckoutOrderMapper());
    }

    @Override
    public int update(CheckoutOrder checkoutOrder) {
        String sql = "UPDATE checkout_order SET name_client = ?,soname_client=?,email_client=?,phone_client=? WHERE id_c_or = ?";
        log.info("Update order info" + " " + new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,checkoutOrder.getName_client(),checkoutOrder.getSoname_client(),
                checkoutOrder.getEmail_client(),
                checkoutOrder.getPhone_client(),checkoutOrder.getId_c_or());
    }

    @Override
    public int delete(CheckoutOrder checkoutOrder) {
        String sql = "DELETE FROM checkout_order WHERE id_c_or=?";
        log.info("Delete order by id - " + checkoutOrder.getId_c_or() + " " + new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,checkoutOrder.getId_c_or());
    }

    @Override
    public CheckoutOrder getById(Long id) {
        String sql = "SELECT * FROM checkout_order WHERE id_c_or=?";
        log.info("Get one order by id - " + id + " " + new Date(new java.util.Date().getTime()));
        return jdbcTemplate.queryForObject(sql,new CheckoutOrderMapper(),id);
    }
}
