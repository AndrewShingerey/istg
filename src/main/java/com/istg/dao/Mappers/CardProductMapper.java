package com.istg.dao.Mappers;

import com.istg.domain.CardProduct;
import com.istg.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CardProductMapper implements RowMapper<CardProduct> {
    @Override
    public CardProduct mapRow(ResultSet resultSet, int i) throws SQLException {
        CardProduct cardProduct = new CardProduct();
        cardProduct.setId_card(resultSet.getLong("id_card"));
        cardProduct.setId_game(resultSet.getLong("id_game"));
        cardProduct.setDate_add(resultSet.getDate("date_add"));
        return cardProduct;
    }
}
