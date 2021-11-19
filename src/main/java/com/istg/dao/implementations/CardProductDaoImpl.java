package com.istg.dao.implementations;

import com.istg.dao.Interface.CardProductDao;
import com.istg.dao.Mappers.CardProductMapper;
import com.istg.domain.Card;
import com.istg.domain.CardProduct;
import com.istg.domain.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class CardProductDaoImpl implements CardProductDao {

    private static final Logger log = Logger.getLogger(String.valueOf(CardProductDaoImpl.class));

    private JdbcTemplate jdbcTemplate;

    public CardProductDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<CardProduct> find_all_by_id_user(Long id_user) {
        String sql = "SELECT * FROM card_product WHERE id_card = (select id_card from card where id_user=?)";
        log.info("Get all game in card by id user - " + id_user +" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.query(sql,new CardProductMapper(),id_user);
    }

    @Override
    public int save(CardProduct cardProduct, User user) {
        String sql = "insert into card_product(id_card,id_game,date_add)values((select id_card from card where id_user = ?),?,?)";
        log.info("Add to card user new game"+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,user.getId_user(),cardProduct.getId_game(),cardProduct.getDate_add());
    }

    @Override
    public int save(CardProduct cardProduct) {
        String sql = "insert into card_product(id_card,id_game)values(?,?)";
        log.info("Add to card user new game"+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,cardProduct.getId_card(),cardProduct.getId_game());
    }

    @Override
    public List<CardProduct> getAll() {
        String sql = "SELECT * FROM card_product";
        log.info("Get all card users"+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.query(sql,new CardProductMapper());
    }

    @Override
    public int update(CardProduct cardProduct) {
        String sql = "UPDATE card_product SET id_game = ? WHERE id_card = ? ";
        log.info("Update card");
        return jdbcTemplate.update(sql,cardProduct.getId_game(),cardProduct.getId_card());
    }

    @Override
    public int delete(CardProduct cardProduct) {
        return 0;
    }

    @Override
    public int delete(CardProduct cardProduct,User user) {
        String sql = "delete from card_product \n" +
                "where ctid in(select ctid from card_product\n" +
                "                where id_card=(select id_card from card where id_user = ?) and id_game=?\n" +
                "                limit 1);";
        log.info("Delete one product from card - " + cardProduct.getId_card()+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,user.getId_user(),cardProduct.getId_game());
    }

    @Override
    public int create_card(User user) {
        String sql_create_card = "INSERT INTO card(id_user)values(?)";
        return jdbcTemplate.update(sql_create_card,user.getId_user());
    }

    @Override
    public boolean checkExists(Long id) {
        String sql = "select exists(select id_card from card where id_user=?)";
        return jdbcTemplate.queryForObject(sql, new RowMapper<Boolean>() {
            @Override
            public Boolean mapRow(ResultSet resultSet, int i) throws SQLException {
                Boolean bool = resultSet.getBoolean("exists");
                return bool;
            }
        },id);
    }


    @Override
    public CardProduct getById(Long id) {
        String sql = "SELECT * FROM card_product WHERE id_card = ? LIMIT 1";
        log.info("Get one card - " + id+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.queryForObject(sql,new CardProductMapper(),id);
    }
}
