package com.istg.dao.Mappers;

import com.istg.domain.FeedBack;
import com.istg.domain.TableGames;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedBackMapper implements RowMapper<FeedBack> {
    @Override
    public FeedBack mapRow(ResultSet resultSet, int i) throws SQLException {
        FeedBack feedBack = new FeedBack();
        feedBack.setId_feedback(resultSet.getLong("id_fd"));
        feedBack.setId_tb_game(resultSet.getLong("id_tbgame"));
        feedBack.setName_client(resultSet.getString("name_client"));
        feedBack.setEmail_client(resultSet.getString("email_client"));
        feedBack.setSoname_client(resultSet.getString("soname_client"));
        feedBack.setMark(resultSet.getInt("mark"));
        return feedBack;
    }
}
