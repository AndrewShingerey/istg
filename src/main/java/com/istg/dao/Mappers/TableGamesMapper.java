package com.istg.dao.Mappers;

import com.istg.domain.TableGames;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TableGamesMapper implements RowMapper<TableGames> {
    @Override
    public TableGames mapRow(ResultSet resultSet, int i) throws SQLException {
        TableGames tableGames = new TableGames();
        tableGames.setId_game(resultSet.getLong("id_game"));
        tableGames.setName_game(resultSet.getString("name_game"));
        tableGames.setDescribe_game(resultSet.getString("describe_game"));
        tableGames.setFilename_photo_game(resultSet.getString("filename_photo"));
        tableGames.setPrice(resultSet.getInt("price"));
        tableGames.setType_id(resultSet.getLong("typegame_id"));
        return tableGames;
    }
}
