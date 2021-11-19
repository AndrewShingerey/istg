package com.istg.dao.Interface;

import com.istg.domain.TableGames;
import com.istg.domain.enums.TypeGame;

import java.util.List;

public interface TableGamesDao extends BaseDaoCRUD<TableGames> {

    List<TableGames>findByName(String nameGames);

    List<TableGames>findByType(TypeGame typeGame);
}
