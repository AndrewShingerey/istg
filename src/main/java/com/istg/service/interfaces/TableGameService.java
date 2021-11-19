package com.istg.service.interfaces;

import com.istg.domain.TableGames;
import com.istg.domain.enums.TypeGame;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface TableGameService extends BaseService<TableGames> {

    List<TableGames> findByName(String nameGames);

    List<TableGames>findByType(TypeGame typeGame);

    void saveFile(TableGames tableGames, MultipartFile file) throws IOException;

}
