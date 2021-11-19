package com.istg.dao.implementations;

import com.istg.dao.Interface.TableGamesDao;
import com.istg.dao.Mappers.TableGamesMapper;
import com.istg.domain.TableGames;
import com.istg.domain.enums.TypeGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

public class TableGameDaoImpl implements TableGamesDao {

    private static final Logger log = Logger.getLogger(String.valueOf(TableGameDaoImpl.class));

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public TableGameDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<TableGames> findByName(String nameGames) {
        String patternForFound = "%"+nameGames+"%";
        String sql = "SELECT * FROM table_games WHERE name_game LIKE ?";
        log.info("Find all table game by name - " + nameGames+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.query(sql,new TableGamesMapper(),patternForFound);
    }

    @Override
    public List<TableGames> findByType(TypeGame typeGame) {
        String sql = "SELECT * FROM table_games WHERE typegame_id = ?" ;
        log.info("Find all table game by type - " + typeGame.getName_type()+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.query(sql,new TableGamesMapper(),typeGame.getId_type());

    }

    @Override
    public int save(TableGames tableGames) {
        String sql = "insert into table_games(name_game,describe_game,price,typegame_id,filename_photo) " +
                "values (?,?,?,?,?);\n";
        log.info("Save new table game:" + tableGames.toString()+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,tableGames.getName_game(),tableGames.getDescribe_game(),
                tableGames.getPrice(),tableGames.getType_id(),tableGames.getFilename_photo_game());
    }

    @Override
    public List<TableGames> getAll() {
        String sql = "SELECT * FROM table_games";
        log.info("Get all table games"+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.query(sql,new TableGamesMapper());
    }

    @Override
    public int update(TableGames tableGames) {
        String sql = "UPDATE table_games SET name_game = ?,describe_game=?,price=?,filename_photo=?,typegame_id=? WHERE id_game = ?";
        log.info("Update table game"+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,tableGames.getName_game(),tableGames.getDescribe_game(),tableGames.getPrice(),
                tableGames.getFilename_photo_game(),tableGames.getType_id(),tableGames.getId_game());
    }

    @Override
    public int delete(TableGames tableGames) {
        String sql = "Delete From table_games WHERE id_game =?";
        log.info("Delete table game by id - " + tableGames.getId_game()+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.update(sql,tableGames.getId_game());
    }

    @Override
    public TableGames getById(Long id) {
        String sql = "SELECT * FROM table_games WHERE id_game=?";
        log.info("Get table game by id - " + id+" "+new Date(new java.util.Date().getTime()));
        return jdbcTemplate.queryForObject(sql,new TableGamesMapper(),id);
    }
}
