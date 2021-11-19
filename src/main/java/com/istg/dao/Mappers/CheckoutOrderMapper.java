package com.istg.dao.Mappers;

import com.istg.domain.CardProduct;
import com.istg.domain.CheckoutOrder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckoutOrderMapper implements RowMapper<CheckoutOrder> {
    @Override
    public CheckoutOrder mapRow(ResultSet resultSet, int i) throws SQLException {
        CheckoutOrder checkoutOrder = new CheckoutOrder();
        checkoutOrder.setId_c_or(resultSet.getLong("id_c_or"));
        checkoutOrder.setId_card_pr(resultSet.getLong("id_card_pr"));
        checkoutOrder.setName_client(resultSet.getString("name_client"));
        checkoutOrder.setSoname_client(resultSet.getString("soname_client"));
        checkoutOrder.setEmail_client(resultSet.getString("email_client"));
        checkoutOrder.setPhone_client(resultSet.getString("phone_client"));
        checkoutOrder.setSumma_order(resultSet.getInt("summa_order"));
        checkoutOrder.setDate_order(resultSet.getDate("date_order"));
        return checkoutOrder;
    }
}
